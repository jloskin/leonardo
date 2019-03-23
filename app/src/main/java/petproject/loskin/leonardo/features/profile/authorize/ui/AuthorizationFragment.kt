package petproject.loskin.leonardo.features.profile.authorize.ui

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.authorization_screen.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.base.ui.MainActivity
import petproject.loskin.leonardo.base.ui.RootFragment
import petproject.loskin.leonardo.features.Screens
import petproject.loskin.leonardo.features.profile.authorize.di.DaggerAuthorizationComponent
import petproject.loskin.leonardo.features.profile.authorize.presenters.AuthorizationPresenter
import javax.inject.Inject

class AuthorizationFragment : RootFragment(), AuthorizationView {
  @Inject @InjectPresenter lateinit var presenter: AuthorizationPresenter
  @ProvidePresenter fun provide() = presenter

  init {
    DaggerAuthorizationComponent.builder().navigationModule(MainActivity.ROOT).build().inject(this)
  }

  override fun layoutId(): Int = R.layout.authorization_screen

  override fun titleId(): Int = R.string.authorization

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    enter.setOnClickListener { presenter.authorize(email.text.toString(), password.text.toString()) }
  }

  override fun authorize(success: Boolean) {
    if (success) router.newRootScreen(Screens.ProfileScreen())
  }
}