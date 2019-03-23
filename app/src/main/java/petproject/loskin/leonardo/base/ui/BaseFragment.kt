package petproject.loskin.leonardo.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import petproject.loskin.leonardo.base.navigation.DaggerNavigationComponent
import ru.terrakok.cicerone.Router
import javax.inject.Inject

abstract class BaseFragment : MvpAppCompatFragment() {
  @Inject lateinit var router: Router

  init {
    DaggerNavigationComponent.builder().navigationModule(MainActivity.ROOT).build().inject(this)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
  ): View = inflater.inflate(layoutId(), container, false)

  abstract fun layoutId(): Int
}