package petproject.loskin.leonardo.features.shop.goods.ui

import android.view.View
import kotlinx.android.synthetic.main.news_cell.view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.features.shop.goods.models.GoodsData
import petproject.loskin.leonardo.util.components.recyclerview.BaseRecyclerAdapter
import petproject.loskin.leonardo.util.components.recyclerview.BaseRecyclerViewHolder
import petproject.loskin.leonardo.util.glide.GlideApp

class GoodsAdapter(
    private val click: (GoodsData) -> Unit
) : BaseRecyclerAdapter<GoodsData, GoodsAdapter.Holder>() {
    override fun item(itemView: View) = Holder(itemView, click)

    override fun getItemViewType(position: Int) = R.layout.good_cell

    class Holder(itemView: View, val click: (GoodsData) -> Unit) : BaseRecyclerViewHolder<GoodsData>(itemView) {
        override fun bind(item: GoodsData) {
            with(itemView) {
                setOnClickListener { click(item) }
                newsTitle.text = item.itemName
                GlideApp.with(newsImage).load(item.img).into(newsImage)
            }
        }
    }
}