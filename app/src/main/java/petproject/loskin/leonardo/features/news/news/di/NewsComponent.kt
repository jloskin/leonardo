package petproject.loskin.leonardo.features.news.news.di

import dagger.Component
import petproject.loskin.leonardo.base.navigation.NavigationModule
import petproject.loskin.leonardo.features.news.news.ui.NewsFragment

@Component(modules = [NewsModule::class, NavigationModule::class])
interface NewsComponent {
  fun inject(fragment: NewsFragment)
}