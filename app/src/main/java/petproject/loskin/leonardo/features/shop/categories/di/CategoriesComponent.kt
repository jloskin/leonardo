package petproject.loskin.leonardo.features.shop.categories.di

import dagger.Component
import petproject.loskin.leonardo.base.db.di.DataBaseModule
import petproject.loskin.leonardo.base.navigation.NavigationModule
import petproject.loskin.leonardo.features.shop.categories.ui.CategoriesFragment

@Component(modules = [DataBaseModule::class, NavigationModule::class, CategoriesModule::class])
interface CategoriesComponent {
    fun inject(fragment: CategoriesFragment)
}