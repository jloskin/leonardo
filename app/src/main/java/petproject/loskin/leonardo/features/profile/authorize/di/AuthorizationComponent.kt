package petproject.loskin.leonardo.features.profile.authorize.di

import dagger.Component
import petproject.loskin.leonardo.base.db.di.DataBaseModule
import petproject.loskin.leonardo.base.navigation.NavigationModule
import petproject.loskin.leonardo.features.profile.authorize.ui.AuthorizationFragment

@Component(modules = [NavigationModule::class, DataBaseModule::class, AuthorizationModule::class])
interface AuthorizationComponent {
    fun inject(fragment: AuthorizationFragment)
}