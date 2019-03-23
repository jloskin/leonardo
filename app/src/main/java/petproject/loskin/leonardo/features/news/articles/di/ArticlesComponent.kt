package petproject.loskin.leonardo.features.news.articles.di

import dagger.Component
import petproject.loskin.leonardo.base.navigation.NavigationModule
import petproject.loskin.leonardo.features.news.articles.ui.ArticlesFragment

@Component(modules = [ArticlesModule::class, NavigationModule::class])
interface ArticlesComponent {
  fun inject(fragment: ArticlesFragment)
}