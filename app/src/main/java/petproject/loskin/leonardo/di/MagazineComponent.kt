package petproject.loskin.leonardo.di

import dagger.Component
import petproject.loskin.leonardo.presentation.ui.magazine.categories.CategoriesFragment
import petproject.loskin.leonardo.presentation.ui.magazine.goods.GoodsFragment
import petproject.loskin.leonardo.presentation.ui.magazine.subcategories.SubCategoriesFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NavigationModule::class,
    LocalNavigationModule::class
])
interface MagazineComponent {
    fun inject(categoriesFragment: CategoriesFragment)

    fun inject(subCategoriesFragment: SubCategoriesFragment)

    fun inject(goodsFragment: GoodsFragment)
}