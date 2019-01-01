package petproject.loskin.leonardo.presentation.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.app_bar_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.model.main.MainViewModel
import petproject.loskin.leonardo.util.cicerone.SupportAppxNavigator
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

class MainActivity : AppCompatActivity() {
  private val router: Router by inject()
  private val navigatorHolder: NavigatorHolder by inject()
  private val viewModel: MainViewModel by viewModel()
  private val navigator: Navigator = SupportAppxNavigator(this, R.id.nav_host_fragment)
  private var menuId: Int? = null
  private var authorize: Boolean = false

  private var menuSelected: ((MenuItem?) -> Boolean)? = null
    set(value) {
      field = value
      invalidateOptionsMenu()
    }
  init {
    router.newRootScreen(Screens.GoodsScreen())
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    viewModel.authorize().subscribe({ authorize = it.isNotEmpty() }, Throwable::printStackTrace)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setSupportActionBar(toolbar)
    with(toolbar) { setNavigationOnClickListener { onBackPressed() } }

    bottom_view.setOnNavigationItemSelectedListener {
      val supportAppxScreen = when (it.itemId) {
        R.id.categoriesFragment -> Screens.GoodsScreen()
        R.id.newsNavFragment -> Screens.MainNewsScreen()
        R.id.authorizeFragment -> {
          if (authorize) Screens.ProfileScreen()
          else Screens.AuthorizeScreen()
        }
        else -> return@setOnNavigationItemSelectedListener false
      }
      router.newRootScreen(supportAppxScreen)
      return@setOnNavigationItemSelectedListener true
    }
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean =
    menuId?.let { menuInflater.inflate(it, menu) }?.let { true } ?: true

  override fun onOptionsItemSelected(item: MenuItem?): Boolean =
    if (menuSelected?.invoke(item) == true) true else super.onOptionsItemSelected(item)

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
