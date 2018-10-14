package petproject.loskin.leonardo.presentation.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.presentation.view.BackButtonListener
import petproject.loskin.leonardo.util.ext.setContentFragment
import javax.inject.Inject


class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = androidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
                .apply {
                    drawer_layout.addDrawerListener(this)
                    syncState()
                }
        setupNavigation()
    }

    private fun setupNavigation() {
        val navController = findNavController(my_nav_host_fragment)
        setupWithNavController(nav_view, navController)
        nav_view.getHeaderView(0).personLogo.setOnClickListener {
            navController.navigate(R.id.authorizeFragment)
            closeDrawer()
        }

        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_goods -> navController.navigate(R.id.categoriesFragment, Bundle(), options)
                else -> {
                }
            }
            closeDrawer()
            true
        }
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

    companion object {
        val options = NavOptions.Builder()
                .setEnterAnim(R.anim.slide_in_right)
                .setExitAnim(R.anim.slide_out_left)
                .setPopEnterAnim(R.anim.slide_in_left)
                .setPopExitAnim(R.anim.slide_out_right)
                .build()
    }
}
