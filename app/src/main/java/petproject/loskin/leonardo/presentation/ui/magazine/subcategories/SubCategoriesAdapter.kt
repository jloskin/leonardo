package petproject.loskin.leonardo.presentation.ui.magazine.subcategories

import android.view.View
import kotlinx.android.synthetic.main.item_magazine.view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.main.SubCategoriesData
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerAdapter
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerViewHolder


class SubCategoriesAdapter(private val click: (SubCategoriesData) -> Unit) : BaseRecyclerAdapter<SubCategoriesData, SubCategoriesAdapter.Holder>() {
    override fun item(itemView: View) = Holder(itemView, click)

    override fun getItemViewType(position: Int) = R.layout.item_magazine

    class Holder(itemView: View, val click: (SubCategoriesData) -> Unit) : BaseRecyclerViewHolder<SubCategoriesData>(itemView) {
        override fun bind(item: SubCategoriesData) {
            itemView.magazine.text = item.itemName
            itemView.setOnClickListener { click(item) }
        }
    }
}