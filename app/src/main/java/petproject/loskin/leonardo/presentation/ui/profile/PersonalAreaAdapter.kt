package petproject.loskin.leonardo.presentation.ui.profile

import android.view.View
import kotlinx.android.synthetic.main.personal_area_cell.view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.data.entity.profile.Menu
import petproject.loskin.leonardo.data.entity.profile.MenuType
import petproject.loskin.leonardo.util.components.recyclerview.BaseRecyclerAdapter
import petproject.loskin.leonardo.util.components.recyclerview.BaseRecyclerViewHolder

class PersonalAreaAdapter(
  private val click: (MenuType) -> Unit
) : BaseRecyclerAdapter<MenuType, PersonalAreaAdapter.Holder>() {
  override fun item(itemView: View) = Holder(itemView, click)

  override fun getItemViewType(position: Int) = R.layout.personal_area_cell

  class Holder(itemView: View, val click: (MenuType) -> Unit) : BaseRecyclerViewHolder<MenuType>(itemView) {
    override fun bind(@Menu.Type item: MenuType) {
      with(itemView) {
        setOnClickListener { click(item) }
        text.setText(Menu.value(item))
      }
    }
  }
}