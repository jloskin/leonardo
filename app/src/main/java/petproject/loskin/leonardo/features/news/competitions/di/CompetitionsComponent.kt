package petproject.loskin.leonardo.features.news.competitions.di

import dagger.Component
import petproject.loskin.leonardo.base.navigation.NavigationModule
import petproject.loskin.leonardo.features.news.competitions.ui.CompetitionsFragment

@Component(modules = [CompetitionsModule::class, NavigationModule::class])
interface CompetitionsComponent {
  fun inject(fragment: CompetitionsFragment)
}