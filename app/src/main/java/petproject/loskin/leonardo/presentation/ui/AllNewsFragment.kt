package petproject.loskin.leonardo.presentation.ui

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import kotlinx.android.synthetic.main.news_screen.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.SampleApplication
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.Replace
import javax.inject.Inject

class AllNewsFragment : MvpAppCompatFragment() {
    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator: SupportAppNavigator by lazy {
        SupportAppNavigator(activity, fragmentManager, R.id.containerNavigation)
    }

    init {
        SampleApplication.INSTANCE.appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.news_screen, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().post { navigator.applyCommands(arrayOf(Replace(Screens.News()))) }
        bottomBar?.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_news -> Screens.News()
                R.id.action_competitions -> Screens.Competitions()
                R.id.action_mclasses -> Screens.MClasses()
                R.id.action_articles -> Screens.Articles()
                else -> null as? SupportAppScreen
            }?.let {
                navigator.applyCommands(arrayOf(Replace(it)))
                true
            } ?: false
        }
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }
}
