package petproject.loskin.leonardo.di

import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module
import org.koin.experimental.builder.factory
import petproject.loskin.leonardo.data.db.AppDatabase
import petproject.loskin.leonardo.data.mapper.authorization.AuthorizationMapper
import petproject.loskin.leonardo.data.mapper.shop.categories.MagazineMapper
import petproject.loskin.leonardo.domain.model.main.LeisureInteractor
import petproject.loskin.leonardo.domain.model.news.NewsViewModel
import petproject.loskin.leonardo.domain.model.news.articles.ArticlesViewModel
import petproject.loskin.leonardo.domain.model.news.competitions.CompetitionsViewModel
import petproject.loskin.leonardo.domain.model.news.mclasses.MClassesViewModel
import petproject.loskin.leonardo.domain.model.profile.MyProfileViewModel
import petproject.loskin.leonardo.domain.model.profile.authorize.AuthorizeViewModel
import petproject.loskin.leonardo.domain.model.shop.categories.CategoriesViewModel
import petproject.loskin.leonardo.domain.model.shop.cities.FilterCityViewModel
import petproject.loskin.leonardo.domain.model.shop.goods.GoodsMapper
import petproject.loskin.leonardo.domain.model.shop.goods.GoodsRepository
import petproject.loskin.leonardo.domain.model.shop.goods.GoodsViewModel
import petproject.loskin.leonardo.domain.model.shop.subcategories.SubCategoriesRepository
import petproject.loskin.leonardo.domain.model.shop.subcategories.SubCategoriesViewModel
import petproject.loskin.leonardo.domain.repositories.news.LeisureRepositories
import petproject.loskin.leonardo.domain.repositories.profile.MyProfileMapper
import petproject.loskin.leonardo.domain.repositories.profile.MyProfileRepository
import petproject.loskin.leonardo.domain.repositories.profile.authorize.AuthorizeRepository
import petproject.loskin.leonardo.domain.repositories.shop.categories.CategoriesRepository
import petproject.loskin.leonardo.domain.repositories.shop.cities.CitiesRepository
import petproject.loskin.leonardo.presentation.ui.MainViewModel
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

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
  factory<MagazineMapper>()
  factory<MyProfileMapper>()
  factory<GoodsMapper>()

  factory<LeisureInteractor>()

  single<Cicerone<Router>> { Cicerone.create() }
  single<NavigatorHolder> { get<Cicerone<Router>>().navigatorHolder }
  single<Router> { get<Cicerone<Router>>().router }

  // Single instance of Repository
  single { AppDatabase.getInstance(get()).categoriesDao() }
  single { AppDatabase.getInstance(get()).profileDao() }
}