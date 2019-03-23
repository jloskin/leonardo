package petproject.loskin.leonardo.base.navigation

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

@Module
class NavigationModule {
  @get:Provides
  val cicerone: Cicerone<Router> by lazy { Cicerone.create() }

  @get:Provides
  val holder: NavigatorHolder by lazy { cicerone.navigatorHolder }

  @get:Provides
  val router: Router by lazy { cicerone.router }
}
