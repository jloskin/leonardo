package petproject.loskin.leonardo.di

import dagger.Component
import petproject.loskin.leonardo.presentation.ui.main.MainActivity
import javax.inject.Singleton


@Singleton
@Component(modules = [
    NavigationModule::class,
    LocalNavigationModule::class
])
interface AppComponent {
    fun inject(activity: MainActivity)
}