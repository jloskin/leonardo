package petproject.loskin.leonardo.presentation.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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
    private var menuId: Int? = null
    private var menuSelected: ((MenuItem?) -> Boolean)? = null
        set(value) {
            field = value
            invalidateOptionsMenu()
        }

    init {
        router.newRootScreen(Screens.GoodsScreen())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        with(toolbar) {
            setNavigationOnClickListener { onBackPressed() }
        }

        bottom_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.categoriesFragment -> Screens.GoodsScreen()
                R.id.newsNavFragment -> Screens.NewsScreen()
                R.id.authorizeFragment -> Screens.AuthorizeScreen()
                else -> null
            }?.let {
                router.newRootScreen(it)
                true
            } ?: false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuId?.let { menuInflater.inflate(it, menu) }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (menuSelected?.invoke(item) == true) return true
        return super.onOptionsItemSelected(item)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    fun clearMenu() {
        menuId = null
        menuSelected = null
    }

    fun setMenu(info: Int, function: (MenuItem?) -> Boolean) {
        menuId = info
        menuSelected = function
    }
}
