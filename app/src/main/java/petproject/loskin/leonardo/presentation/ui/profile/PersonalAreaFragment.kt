package petproject.loskin.leonardo.presentation.ui.profile

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.android.ext.android.inject
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.presentation.ui.Screens
import petproject.loskin.leonardo.presentation.ui.base.RootFragment
import petproject.loskin.leonardo.data.entity.profile.Menu.BILLS
import petproject.loskin.leonardo.data.entity.profile.Menu.EDIT
import petproject.loskin.leonardo.data.entity.profile.Menu.FEEDBACK
import petproject.loskin.leonardo.data.entity.profile.Menu.KONKURS
import petproject.loskin.leonardo.data.entity.profile.Menu.MASTER_LIST
import petproject.loskin.leonardo.data.entity.profile.Menu.MASTER_MKRATING
import petproject.loskin.leonardo.data.entity.profile.Menu.MCLASSSUBSCRIBE
import petproject.loskin.leonardo.data.entity.profile.Menu.ORDERS
import petproject.loskin.leonardo.data.entity.profile.Menu.PROFILE
import petproject.loskin.leonardo.data.entity.profile.Menu.REVIEWS
import petproject.loskin.leonardo.data.entity.profile.Menu.TICKETS
import petproject.loskin.leonardo.data.entity.profile.MenuType
import petproject.loskin.leonardo.domain.model.profile.ProfileViewModel

class PersonalAreaFragment : RootFragment() {
  private val viewModel: ProfileViewModel by inject()

  override fun layoutId(): Int = R.layout.recycler_view

  override fun titleId(): Int = R.string.profile

  private val adapter by lazy {
    PersonalAreaAdapter({
      when (it) {
        PROFILE -> router.navigateTo(Screens.Profile.MyProfile())
        EDIT -> router.navigateTo(Screens.Profile.Edit())
        KONKURS -> R.string.profile_konkurs
        FEEDBACK -> R.string.profile_feedback
        MASTER_LIST -> R.string.profile_master_list
        MASTER_MKRATING -> R.string.profile_master_mkrating
        ORDERS -> R.string.profile_orders
        TICKETS -> R.string.profile_tickets
        MCLASSSUBSCRIBE -> R.string.profile_mclasssubscribe
        REVIEWS -> R.string.profile_reviews
        BILLS -> R.string.profile_bills
      }
    })
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    adapter.update(MENUS)

    with(recyclerView) {
      val linearLayoutManager = LinearLayoutManager(context)
      adapter = this@PersonalAreaFragment.adapter
      layoutManager = linearLayoutManager
      addItemDecoration(DividerItemDecoration(context, linearLayoutManager.orientation))
    }
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