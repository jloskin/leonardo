package petproject.loskin.leonardo.features.profile.myprofile.di

import dagger.Component
import petproject.loskin.leonardo.base.navigation.NavigationModule
import petproject.loskin.leonardo.features.profile.myprofile.ui.MyProfileFragment

@Component(modules = [MyProfileModule::class, NavigationModule::class])
interface MyProfileComponent {
    fun inject(fragment: MyProfileFragment)
}