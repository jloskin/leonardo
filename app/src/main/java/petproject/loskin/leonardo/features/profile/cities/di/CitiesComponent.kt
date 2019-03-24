package petproject.loskin.leonardo.features.profile.cities.di

import dagger.Component
import petproject.loskin.leonardo.base.db.di.DataBaseModule
import petproject.loskin.leonardo.base.navigation.NavigationModule
import petproject.loskin.leonardo.features.profile.cities.ui.CitiesFragment

@Component(modules = [CitiesModule::class, NavigationModule::class, DataBaseModule::class])
interface CitiesComponent {
    fun inject(fragment: CitiesFragment)
}