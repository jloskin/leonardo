package petproject.loskin.leonardo.presentation.ui

import android.view.View
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.presentation.ui.profile.Menu
import petproject.loskin.leonardo.util.components.recyclerview.BaseRecyclerAdapter
import petproject.loskin.leonardo.util.components.recyclerview.BaseRecyclerViewHolder

class ProfileAdapter(
  menus: Set<Menu>,
  private val click: (Menu) -> Unit
) : BaseRecyclerAdapter<Menu, ProfileAdapter.Holder>() {
  override fun item(itemView: View) = Holder(itemView, click)

  override fun getItemViewType(position: Int) = R.layout.magazine_cell

  class Holder(itemView: View, val click: (Menu) -> Unit) : BaseRecyclerViewHolder<Menu>(itemView) {
    override fun bind(item: Menu) {
      with(itemView) {
        setOnClickListener { click(item) }
      }
    }
  }
}