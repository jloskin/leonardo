package petproject.loskin.leonardo.presentation.ui.main

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.SampleApplication
import petproject.loskin.leonardo.presentation.presenter.MainPresenter
import petproject.loskin.leonardo.presentation.view.BackButtonListener
import petproject.loskin.leonardo.presentation.view.main.MainView
import javax.inject.Inject


class MainActivity : MvpAppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, MainView {
    @InjectPresenter
    @Inject
    lateinit var presenter: MainPresenter

    init {
        SampleApplication.INSTANCE.appComponent.inject(this)
    }

    @ProvidePresenter
    fun presenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
                .apply {
                    drawer_layout.addDrawerListener(this)
                    syncState()
                }
        nav_view.setNavigationItemSelectedListener(this)

        setupNavigation()
    }

    private fun setupNavigation() {
        val navController = findNavController(my_nav_host_fragment)
        setupWithNavController(nav_view, navController)
        nav_view.getHeaderView(0).personLogo.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.subCategoriesFragment, null)
        )
    }

    override fun onSupportNavigateUp() = findNavController(my_nav_host_fragment).navigateUp()

    override fun onBackPressed() {
        if (closeDrawer()) return

        val fragment = supportFragmentManager.findFragmentById(R.id.container)
        if ((fragment as? BackButtonListener)?.onBackPressed() == true) {
            return
        } else {
            super.onBackPressed()
        }
    }

    private fun closeDrawer(): Boolean {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
            return true
        }
        return false
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_goods -> {}
            R.id.nav_news -> {}
            R.id.nav_share -> {
            }
        }

        closeDrawer()
        return true
    }

    companion object {
        val options = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
                .build()
    }
}
