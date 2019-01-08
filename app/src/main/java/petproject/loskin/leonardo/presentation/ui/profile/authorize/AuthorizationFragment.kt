package petproject.loskin.leonardo.presentation.ui.profile.authorize

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.authorization_screen.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.model.profile.authorize.AuthorizationViewModel
import petproject.loskin.leonardo.presentation.ui.Screens
import petproject.loskin.leonardo.presentation.ui.base.RootFragment

class AuthorizationFragment : RootFragment() {
  private val viewModel: AuthorizationViewModel by viewModel()

  override fun layoutId(): Int = R.layout.authorization_screen

  override fun titleId(): Int = R.string.authorization

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel.authorized.observe(this, Observer { if (it) router.newRootScreen(Screens.ProfileScreen()) })
    enter.setOnClickListener { viewModel.authorize(email.text.toString(), password.text.toString()) }
  }
}
