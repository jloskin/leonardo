package petproject.loskin.leonardo.features.profile

import dagger.Component
import petproject.loskin.leonardo.base.db.di.DataBaseModule
import petproject.loskin.leonardo.base.navigation.NavigationModule

@Component(modules = [NavigationModule::class, DataBaseModule::class, ProfileModule::class])
interface ProfileComponent {
  fun inject(fragment: ProfileFragment)
}