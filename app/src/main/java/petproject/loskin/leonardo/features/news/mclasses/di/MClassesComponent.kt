package petproject.loskin.leonardo.features.news.mclasses.di

import dagger.Component
import petproject.loskin.leonardo.base.navigation.NavigationModule
import petproject.loskin.leonardo.features.news.mclasses.ui.MClassesFragment

@Component(modules = [MClassesModule::class, NavigationModule::class])
interface MClassesComponent {
  fun inject(fragment: MClassesFragment)
}