package petproject.loskin.leonardo.features.shop.subcategories.di

import dagger.Component
import petproject.loskin.leonardo.base.db.di.DataBaseModule
import petproject.loskin.leonardo.base.navigation.NavigationModule
import petproject.loskin.leonardo.features.shop.subcategories.ui.SubCategoriesFragment

@Component(modules = [SubCategoriesModule::class, NavigationModule::class, DataBaseModule::class])
interface SubCategoriesComponent {
  fun inject(fragment: SubCategoriesFragment)
}