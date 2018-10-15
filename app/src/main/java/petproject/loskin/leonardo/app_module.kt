package petproject.loskin.leonardo

import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module
import org.koin.experimental.builder.factory
import petproject.loskin.leonardo.data.db.AppDatabase
import petproject.loskin.leonardo.domain.main.MainInteractor
import petproject.loskin.leonardo.presentation.ui.magazine.categories.CategoriesMapper
import petproject.loskin.leonardo.presentation.ui.magazine.categories.CategoriesRepository
import petproject.loskin.leonardo.presentation.ui.magazine.categories.CategoriesViewModel
import petproject.loskin.leonardo.presentation.ui.magazine.goods.GoodsViewModel
import petproject.loskin.leonardo.presentation.ui.magazine.subcategories.SubCategoriesViewModel
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