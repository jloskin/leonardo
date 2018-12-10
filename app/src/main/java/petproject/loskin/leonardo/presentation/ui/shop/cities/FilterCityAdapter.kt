package petproject.loskin.leonardo.presentation.ui.shop.cities

import android.view.View
import kotlinx.android.synthetic.main.chips_cell.view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.data.entity.shop.City
import petproject.loskin.leonardo.util.components.recyclerview.BaseRecyclerAdapter
import petproject.loskin.leonardo.util.components.recyclerview.BaseRecyclerViewHolder

class FilterCityAdapter(
  private val click: (City) -> Unit
) : BaseRecyclerAdapter<City, FilterCityAdapter.Holder>() {
  override fun item(itemView: View) = Holder(itemView, click)

  override fun getItemViewType(position: Int) = R.layout.chips_cell

  class Holder(
    itemView: View,
    val click: (City) -> Unit
  ) : BaseRecyclerViewHolder<City>(itemView) {
    override fun bind(item: City) {
      with(itemView) {
        setOnClickListener { click(item) }
        newsTitle.text = item.title
      }
    }
  }
}