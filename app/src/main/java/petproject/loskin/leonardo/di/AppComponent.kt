package petproject.loskin.leonardo.di

import dagger.Component
import petproject.loskin.leonardo.presentation.ui.AllNewsFragment
import petproject.loskin.leonardo.presentation.ui.articles.ArticlesFragment
import petproject.loskin.leonardo.presentation.ui.competitions.fragment.CompetitionsFragment
import petproject.loskin.leonardo.presentation.ui.magazine.MagazineFragment
import petproject.loskin.leonardo.presentation.ui.main.MainActivity
import petproject.loskin.leonardo.presentation.ui.mclasses.MClassesFragment
import petproject.loskin.leonardo.presentation.ui.news.NewsFragment
import javax.inject.Singleton


@Singleton
@Component(modules = [
    NavigationModule::class,
    LocalNavigationModule::class
])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: NewsFragment)
    fun inject(fragment: AllNewsFragment)
    fun inject(fragment: MagazineFragment)
    fun inject(fragment: CompetitionsFragment)
    fun inject(fragment: MClassesFragment)
    fun inject(fragment: ArticlesFragment)
}