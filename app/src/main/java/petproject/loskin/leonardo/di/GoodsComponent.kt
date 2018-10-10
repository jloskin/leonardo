package petproject.loskin.leonardo.di

import dagger.Component
import petproject.loskin.leonardo.presentation.ui.GoodsSubCategoriesFragment
import petproject.loskin.leonardo.presentation.ui.magazine.GoodsCategoriesFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NavigationModule::class,
    LocalNavigationModule::class
])
interface GoodsComponent {
    fun inject(categoriesFragment: GoodsCategoriesFragment)
    fun inject(fragment: GoodsSubCategoriesFragment)
}