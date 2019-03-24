package petproject.loskin.leonardo.features.profile.base.di

import dagger.Component
import petproject.loskin.leonardo.base.db.di.DataBaseModule
import petproject.loskin.leonardo.base.navigation.NavigationModule
import petproject.loskin.leonardo.features.profile.base.ui.ProfileFragment

@Component(modules = [NavigationModule::class, DataBaseModule::class, ProfileModule::class])
interface ProfileComponent {
    fun inject(fragment: ProfileFragment)
}