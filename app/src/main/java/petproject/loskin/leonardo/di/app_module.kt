package petproject.loskin.leonardo.di

import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module
import org.koin.experimental.builder.factory
import petproject.loskin.leonardo.data.db.AppDatabase
import petproject.loskin.leonardo.domain.main.MainInteractor
import petproject.loskin.leonardo.data.mapper.magazine.categories.CategoriesMapper
import petproject.loskin.leonardo.repositories.magazine.categories.CategoriesRepository
import petproject.loskin.leonardo.domain.magazine.categories.CategoriesViewModel
import petproject.loskin.leonardo.domain.magazine.goods.GoodsViewModel
import petproject.loskin.leonardo.domain.magazine.subcategories.SubCategoriesViewModel
import petproject.loskin.leonardo.repositories.MainRepositories

val appModule = module {
    viewModel<CategoriesViewModel>()
    viewModel<SubCategoriesViewModel>()
    viewModel<GoodsViewModel>()

    factory<CategoriesMapper>()
    factory<MainInteractor>()
    factory<MainRepositories>()

    // Single instance of Repository
    single { CategoriesRepository(AppDatabase.getInstance(get()).categoriesDao(), get()) }
}