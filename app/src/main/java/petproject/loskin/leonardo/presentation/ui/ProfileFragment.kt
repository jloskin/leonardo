package petproject.loskin.leonardo.presentation.ui

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.android.ext.android.inject
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.presentation.ui.base.RootFragment
import petproject.loskin.leonardo.presentation.ui.profile.Menu.BILLS
import petproject.loskin.leonardo.presentation.ui.profile.Menu.EDIT
import petproject.loskin.leonardo.presentation.ui.profile.Menu.FEEDBACK
import petproject.loskin.leonardo.presentation.ui.profile.Menu.KONKURS
import petproject.loskin.leonardo.presentation.ui.profile.Menu.MASTER_LIST
import petproject.loskin.leonardo.presentation.ui.profile.Menu.MASTER_MKRATING
import petproject.loskin.leonardo.presentation.ui.profile.Menu.MCLASSSUBSCRIBE
import petproject.loskin.leonardo.presentation.ui.profile.Menu.ORDERS
import petproject.loskin.leonardo.presentation.ui.profile.Menu.PROFILE
import petproject.loskin.leonardo.presentation.ui.profile.Menu.REVIEWS
import petproject.loskin.leonardo.presentation.ui.profile.Menu.TICKETS
import petproject.loskin.leonardo.presentation.ui.profile.MenuType

class ProfileFragment : RootFragment() {
  private val viewModel: ProfileViewModel by inject()

  override fun layoutId(): Int = R.layout.recycler_view

  override fun titleId(): Int = R.string.profile

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    recyclerView.adapter = ProfileAdapter(MENUS, {})
  }

  companion object {
    private val MENUS: Set<MenuType> = setOf(
      PROFILE,
      EDIT,
      KONKURS,
      FEEDBACK,
      MASTER_LIST,
      MASTER_MKRATING,
      ORDERS,
      TICKETS,
      MCLASSSUBSCRIBE,
      REVIEWS,
      BILLS
    )
  }
}