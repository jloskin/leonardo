package petproject.loskin.leonardo.presentation.ui

import org.koin.android.ext.android.inject
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.presentation.ui.base.RootFragment

class ProfileFragment : RootFragment() {
  private val viewModel: ProfileViewModel by inject()

  override fun layoutId(): Int = R.layout.profile_screen

  override fun titleId(): Int = R.string.profile
}
