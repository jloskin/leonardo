package petproject.loskin.leonardo.presentation.ui

import android.view.View
import kotlinx.android.synthetic.main.news_cell.view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.data.mapper.magazine.categories.City
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerAdapter
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerViewHolder

class FilterCityAdapter(
        private val click: (City) -> Unit
) : BaseRecyclerAdapter<City, FilterCityAdapter.Holder>() {
    override fun item(itemView: View) = Holder(itemView, click)

    override fun getItemViewType(position: Int) = R.layout.magazine_cell

    class Holder(itemView: View, val click: (City) -> Unit) : BaseRecyclerViewHolder<City>(itemView) {
        override fun bind(item: City) {
            with(itemView) {
                setOnClickListener { click(item) }
                newsTitle.text = item.title
            }
        }
    }
}