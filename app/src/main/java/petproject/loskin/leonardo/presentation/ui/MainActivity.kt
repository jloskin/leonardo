package petproject.loskin.leonardo.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.app_bar_main.*
import org.koin.android.ext.android.inject
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.util.cicerone.SupportAppxNavigator
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router


class MainActivity : AppCompatActivity() {
    private val router: Router by inject()
    private val navigatorHolder: NavigatorHolder by inject()
    private val navigator: Navigator = SupportAppxNavigator(this, R.id.nav_host_fragment)

    init {
        router.newRootScreen(Screens.GoodsScreen())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        with(toolbar) {
            setNavigationOnClickListener { onBackPressed() }
//            navigationIcon = VectorDrawableCompat.create(resources, R.drawable.abc_ic_ab_back_material, null)
        }

        bottom_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.categoriesFragment -> {
                    router.newRootScreen(Screens.GoodsScreen())
                    true
                }
                R.id.newsNavFragment -> {
                    router.newRootScreen(Screens.NewsScreen())
                    true
                }
                else -> false
            }
        }

    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }
}
