package petproject.loskin.leonardo.presentation.ui.magazine

import android.view.View
import kotlinx.android.synthetic.main.item_magazine.view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.main.ItemMagazine
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerAdapter
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerViewHolder


class DownLevelAdapter(private val click: (ItemMagazine) -> Unit) : BaseRecyclerAdapter<ItemMagazine, DownLevelAdapter.Holder>() {
    override fun item(itemView: View) = Holder(itemView, click)

    override fun getItemViewType(position: Int) = R.layout.item_magazine

    class Holder(itemView: View, val click: (ItemMagazine) -> Unit) : BaseRecyclerViewHolder<ItemMagazine>(itemView) {
        override fun bind(item: ItemMagazine) {
            itemView.magazine.text = item.itemName
            itemView.setOnClickListener { click(item) }
        }
    }
}