package petproject.loskin.leonardo.di

import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module
import org.koin.experimental.builder.factory
import petproject.loskin.leonardo.data.db.AppDatabase
import petproject.loskin.leonardo.data.mapper.profile.authorization.AuthorizationMapper
import petproject.loskin.leonardo.data.mapper.shop.categories.CategoriesMapper
import petproject.loskin.leonardo.data.network.interceptor.AddCookiesInterceptor
import petproject.loskin.leonardo.data.network.interceptor.ReceivedCookiesInterceptor
import petproject.loskin.leonardo.data.network.services.news.NewsService
import petproject.loskin.leonardo.data.network.services.profile.ProfileService
import petproject.loskin.leonardo.data.network.services.profile.authorization.AuthorizeService
import petproject.loskin.leonardo.data.network.services.shop.categories.CategoriesService
import petproject.loskin.leonardo.data.network.services.shop.goods.GoodsService
import petproject.loskin.leonardo.domain.model.news.NewsViewModel
import petproject.loskin.leonardo.domain.model.news.articles.ArticlesViewModel
import petproject.loskin.leonardo.domain.model.news.competitions.CompetitionsViewModel
import petproject.loskin.leonardo.domain.model.news.mclasses.MClassesViewModel
import petproject.loskin.leonardo.domain.model.profile.MyProfileViewModel
import petproject.loskin.leonardo.domain.model.profile.authorize.AuthorizeViewModel
import petproject.loskin.leonardo.domain.model.shop.categories.CategoriesViewModel
import petproject.loskin.leonardo.domain.model.shop.cities.FilterCityViewModel
import petproject.loskin.leonardo.data.mapper.shop.goods.GoodsMapper
import petproject.loskin.leonardo.domain.repositories.shop.GoodsRepository
import petproject.loskin.leonardo.domain.model.shop.goods.GoodsViewModel
import petproject.loskin.leonardo.domain.repositories.shop.subcategories.SubCategoriesRepository
import petproject.loskin.leonardo.domain.model.shop.subcategories.SubCategoriesViewModel
import petproject.loskin.leonardo.domain.repositories.news.LeisureRepositories
import petproject.loskin.leonardo.data.mapper.profile.MyProfileMapper
import petproject.loskin.leonardo.domain.repositories.profile.MyProfileRepository
import petproject.loskin.leonardo.domain.repositories.profile.authorize.AuthorizeRepository
import petproject.loskin.leonardo.domain.repositories.shop.categories.CategoriesRepository
import petproject.loskin.leonardo.domain.repositories.shop.cities.CitiesRepository
import petproject.loskin.leonardo.domain.model.main.MainViewModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import java.util.concurrent.TimeUnit

val appModule = module {
  viewModel<CategoriesViewModel>()
  viewModel<SubCategoriesViewModel>()
  viewModel<GoodsViewModel>()
  viewModel<FilterCityViewModel>()
  viewModel<AuthorizeViewModel>()
  viewModel<MainViewModel>()
  viewModel<NewsViewModel>()
  viewModel<MyProfileViewModel>()
  viewModel<MClassesViewModel>()
  viewModel<ArticlesViewModel>()
  viewModel<CompetitionsViewModel>()

  factory<LeisureRepositories>()
  factory<CategoriesRepository>()
  factory<SubCategoriesRepository>()
  factory<GoodsRepository>()
  factory<AuthorizeRepository>()
  factory<CitiesRepository>()
  factory<MyProfileRepository>()

  factory<AuthorizationMapper>()
  factory<CategoriesMapper>()
  factory<MyProfileMapper>()
  factory<GoodsMapper>()

  factory { get<Retrofit>().create(ProfileService::class.java) }
  factory { get<Retrofit>().create(NewsService::class.java) }
  factory { get<Retrofit>().create(AuthorizeService::class.java) }
  factory { get<Retrofit>().create(CategoriesService::class.java) }
  factory { get<Retrofit>().create(GoodsService::class.java) }

  single<Cicerone<Router>> { Cicerone.create() }
  single<NavigatorHolder> { get<Cicerone<Router>>().navigatorHolder }
  single<Router> { get<Cicerone<Router>>().router }

  // Single instance of Repository
  single { AppDatabase.getInstance(get()).categoriesDao() }
  single { AppDatabase.getInstance(get()).profileDao() }
  single<Retrofit> {
    val baseUrl = "https://leonardohobby.ru/"
    val seconds: Long = 300
    val mutableSet: MutableSet<String> = mutableSetOf(
      "PHPSESSID=l9oc1imkbdu3k6r5mhe8f9hk34; path=/"
    )

    Retrofit.Builder()
      .baseUrl(baseUrl)
      .client(
        OkHttpClient().newBuilder()
          .connectTimeout(seconds, TimeUnit.SECONDS)
          .readTimeout(seconds, TimeUnit.SECONDS)
          .writeTimeout(seconds, TimeUnit.SECONDS)
          .also {
            it.interceptors().addAll(listOf(
              ReceivedCookiesInterceptor(mutableSet),
              AddCookiesInterceptor(mutableSet)
            ))
          }
          .build()
      )
      .addConverterFactory(ScalarsConverterFactory.create())
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .build()
  }
}