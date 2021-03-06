package petproject.loskin.leonardo.base.navigation

import dagger.Component
import petproject.loskin.leonardo.base.ui.BaseFragment
import petproject.loskin.leonardo.base.ui.MainActivity

@Component(modules = [NavigationModule::class])
interface NavigationComponent {
    fun inject(baseFragment: BaseFragment)

    fun inject(baseFragment: MainActivity)
}