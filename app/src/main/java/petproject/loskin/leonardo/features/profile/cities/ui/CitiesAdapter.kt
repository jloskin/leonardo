package petproject.loskin.leonardo.features.profile.cities.ui

import android.view.View
import kotlinx.android.synthetic.main.chips_cell.view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.base.db.dao.profile.City
import petproject.loskin.leonardo.util.components.recyclerview.BaseRecyclerAdapter
import petproject.loskin.leonardo.util.components.recyclerview.BaseRecyclerViewHolder

class CitiesAdapter(
    private val click: (City) -> Unit
) : BaseRecyclerAdapter<City, CitiesAdapter.Holder>() {
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