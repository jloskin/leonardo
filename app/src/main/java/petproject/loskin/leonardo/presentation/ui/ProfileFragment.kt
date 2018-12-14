package petproject.loskin.leonardo.presentation.ui

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.android.ext.android.inject
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.presentation.ui.base.RootFragment
import petproject.loskin.leonardo.presentation.ui.profile.Const.BILLS
import petproject.loskin.leonardo.presentation.ui.profile.Const.EDIT
import petproject.loskin.leonardo.presentation.ui.profile.Const.FEEDBACK
import petproject.loskin.leonardo.presentation.ui.profile.Const.KONKURS
import petproject.loskin.leonardo.presentation.ui.profile.Const.MASTER_LIST
import petproject.loskin.leonardo.presentation.ui.profile.Const.MASTER_MKRATING
import petproject.loskin.leonardo.presentation.ui.profile.Const.MCLASSSUBSCRIBE
import petproject.loskin.leonardo.presentation.ui.profile.Const.ORDERS
import petproject.loskin.leonardo.presentation.ui.profile.Const.PROFILE
import petproject.loskin.leonardo.presentation.ui.profile.Const.REVIEWS
import petproject.loskin.leonardo.presentation.ui.profile.Const.TICKETS
import petproject.loskin.leonardo.presentation.ui.profile.Menu

class ProfileFragment : RootFragment() {
  private val viewModel: ProfileViewModel by inject()

  override fun layoutId(): Int = R.layout.recycler_view

  override fun titleId(): Int = R.string.profile

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    recyclerView.adapter = ProfileAdapter(menus, {})
  }

  companion object {
    private val menus: Set<Menu> = setOf(
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