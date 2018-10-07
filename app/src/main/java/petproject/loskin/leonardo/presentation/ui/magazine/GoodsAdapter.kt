package petproject.loskin.leonardo.presentation.ui.magazine

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.news_cell.view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.data.entity.ItemL
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerAdapter
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerViewHolder


class GoodsAdapter(private val click: (ItemL) -> Unit) : BaseRecyclerAdapter<ItemL, GoodsAdapter.Holder>() {
    override fun item(itemView: View) = Holder(itemView, click)

    override fun getItemViewType(position: Int) = R.layout.good_cell

    class Holder(itemView: View, val click: (ItemL) -> Unit) : BaseRecyclerViewHolder<ItemL>(itemView) {
        override fun bind(item: ItemL) {
            itemView.setOnClickListener { click(item) }
            itemView.newsTitle.text = item.itemName
            Glide.with(itemView.newsImage)
                    .load(item.img)
                    .into(itemView.newsImage)
        }
    }
}