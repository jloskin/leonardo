package petproject.loskin.leonardo.presentation.ui

import android.view.View
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.presentation.ui.profile.MenuType
import petproject.loskin.leonardo.util.components.recyclerview.BaseRecyclerAdapter
import petproject.loskin.leonardo.util.components.recyclerview.BaseRecyclerViewHolder

class ProfileAdapter(
  menus: Set<MenuType>,
  private val click: (MenuType) -> Unit
) : BaseRecyclerAdapter<MenuType, ProfileAdapter.Holder>() {
  override fun item(itemView: View) = Holder(itemView, click)

  override fun getItemViewType(position: Int) = R.layout.magazine_cell

  class Holder(itemView: View, val click: (MenuType) -> Unit) : BaseRecyclerViewHolder<MenuType>(itemView) {
    override fun bind(item: MenuType) {
      with(itemView) {
        setOnClickListener { click(item) }
      }
    }
  }
}