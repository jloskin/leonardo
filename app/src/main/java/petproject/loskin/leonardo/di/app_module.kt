package petproject.loskin.leonardo.di

import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module
import org.koin.experimental.builder.factory
import petproject.loskin.leonardo.data.db.AppDatabase
import petproject.loskin.leonardo.data.mapper.magazine.categories.CategoriesMapper
import petproject.loskin.leonardo.domain.magazine.categories.CategoriesViewModel
import petproject.loskin.leonardo.domain.magazine.goods.GoodsViewModel
import petproject.loskin.leonardo.domain.magazine.subcategories.SubCategoriesViewModel
import petproject.loskin.leonardo.domain.main.MainInteractor
import petproject.loskin.leonardo.presentation.presenter.news.NewsViewModel
import petproject.loskin.leonardo.presentation.presenter.news.articles.ArticlesPresenter
import petproject.loskin.leonardo.presentation.presenter.news.competitions.CompetitionsPresenter
import petproject.loskin.leonardo.presentation.presenter.news.mclasses.MClassesPresenter
import petproject.loskin.leonardo.repositories.MainRepositories
import petproject.loskin.leonardo.repositories.magazine.categories.CategoriesRepository
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

val appModule = module {
    viewModel<CategoriesViewModel>()
    viewModel<SubCategoriesViewModel>()
    viewModel<GoodsViewModel>()

    viewModel<NewsViewModel>()
    viewModel<MClassesPresenter>()
    viewModel<ArticlesPresenter>()
    viewModel<CompetitionsPresenter>()

    factory<CategoriesMapper>()
    factory<MainInteractor>()
    factory<MainRepositories>()

    single<Cicerone<Router>> { Cicerone.create() }
    single<NavigatorHolder> { get<Cicerone<Router>>().navigatorHolder }
    single<Router> { get<Cicerone<Router>>().router }

    // Single instance of Repository
    single { CategoriesRepository(AppDatabase.getInstance(get()).categoriesDao(), get()) }
}