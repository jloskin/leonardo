package petproject.loskin.leonardo.presentation.ui.magazine.goods

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.news_cell.view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.data.entity.GoodsData
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerAdapter
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerViewHolder


class GoodsAdapter(private val click: (GoodsData) -> Unit) : BaseRecyclerAdapter<GoodsData, GoodsAdapter.Holder>() {
    override fun item(itemView: View) = Holder(itemView, click)

    override fun getItemViewType(position: Int) = R.layout.good_cell

    class Holder(itemView: View, val click: (GoodsData) -> Unit) : BaseRecyclerViewHolder<GoodsData>(itemView) {
        override fun bind(item: GoodsData) {
            itemView.setOnClickListener { click(item) }
            itemView.newsTitle.text = item.itemName
            Glide.with(itemView.newsImage)
                    .load(item.img)
                    .into(itemView.newsImage)
        }
    }
}