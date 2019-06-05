package petproject.loskin.leonardo.base.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.app_bar_main.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.base.navigation.DaggerNavigationComponent
import petproject.loskin.leonardo.base.navigation.NavigationModule
import petproject.loskin.leonardo.features.Screens
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var router: Router
    @Inject lateinit var navigatorHolder: NavigatorHolder
    private val navigator: Navigator = SupportAppNavigator(this, R.id.nav_host_fragment)
    private var menuId: Int = 0
    private var menuSelected: (MenuItem) -> Boolean = { false }
        set(value) {
            field = value
            invalidateOptionsMenu()
        }

    init {
        DaggerNavigationComponent.builder().navigationModule(ROOT).build().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        with(toolbar) { setNavigationOnClickListener { onBackPressed() } }

        bottom_view.setOnNavigationItemSelectedListener {
            val supportAppxScreen = when (it.itemId) {
                R.id.categoriesFragment -> Screens.GoodsScreen()
                R.id.newsNavFragment -> Screens.MainNewsScreen()
                R.id.authorizeFragment -> Screens.ProfileScreen()
                else -> return@setOnNavigationItemSelectedListener false
            }
            router.newRootScreen(supportAppxScreen)
            return@setOnNavigationItemSelectedListener true
        }
        bottom_view.selectedItemId = R.id.categoriesFragment
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean =
        if (menuId != 0) {
            menuInflater.inflate(menuId, menu)
            true
        } else false

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val menuItem = item ?: return super.onOptionsItemSelected(item)
        return if (menuSelected(menuItem)) true else super.onOptionsItemSelected(item)
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
        menuId = 0
        menuSelected = { false }
    }

    fun setMenu(info: Int, function: (MenuItem) -> Boolean) {
        menuId = info
        menuSelected = function
    }

    companion object {
        val ROOT = NavigationModule()
    }
}
