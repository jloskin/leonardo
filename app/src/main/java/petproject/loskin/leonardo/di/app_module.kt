package petproject.loskin.leonardo.di

import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module
import org.koin.experimental.builder.factory
import petproject.loskin.leonardo.data.db.AppDatabase
import petproject.loskin.leonardo.data.mapper.shop.categories.MagazineMapper
import petproject.loskin.leonardo.domain.model.shop.categories.CategoriesViewModel
import petproject.loskin.leonardo.domain.model.shop.goods.GoodsMapper
import petproject.loskin.leonardo.domain.model.shop.goods.GoodsRepository
import petproject.loskin.leonardo.domain.model.shop.goods.GoodsViewModel
import petproject.loskin.leonardo.domain.model.shop.subcategories.SubCategoriesRepository
import petproject.loskin.leonardo.domain.model.shop.subcategories.SubCategoriesViewModel
import petproject.loskin.leonardo.domain.model.main.MainInteractor
import petproject.loskin.leonardo.domain.model.news.NewsViewModel
import petproject.loskin.leonardo.domain.model.news.articles.ArticlesPresenter
import petproject.loskin.leonardo.domain.model.news.competitions.CompetitionsPresenter
import petproject.loskin.leonardo.domain.model.news.mclasses.MClassesPresenter
import petproject.loskin.leonardo.domain.model.profile.authorize.AuthorizeViewModel
import petproject.loskin.leonardo.domain.repositories.shop.cities.CitiesRepository
import petproject.loskin.leonardo.domain.model.shop.cities.FilterCityViewModel
import petproject.loskin.leonardo.domain.repositories.MainRepositories
import petproject.loskin.leonardo.domain.repositories.shop.categories.CategoriesRepository
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

val appModule = module {
    viewModel<CategoriesViewModel>()
    viewModel<SubCategoriesViewModel>()
    viewModel<GoodsViewModel>()
    viewModel<FilterCityViewModel>()
    viewModel<AuthorizeViewModel>()

    viewModel<NewsViewModel>()
    viewModel<MClassesPresenter>()
    viewModel<ArticlesPresenter>()
    viewModel<CompetitionsPresenter>()

    factory<MagazineMapper>()
    factory<MainInteractor>()
    factory<MainRepositories>()
    factory<CategoriesRepository>()
    factory<SubCategoriesRepository>()
    factory<GoodsRepository>()
    factory<GoodsMapper>()
    factory<CitiesRepository>()

    single<Cicerone<Router>> { Cicerone.create() }
    single<NavigatorHolder> { get<Cicerone<Router>>().navigatorHolder }
    single<Router> { get<Cicerone<Router>>().router }

    // Single instance of Repository
    single { AppDatabase.getInstance(get()).categoriesDao() }
}