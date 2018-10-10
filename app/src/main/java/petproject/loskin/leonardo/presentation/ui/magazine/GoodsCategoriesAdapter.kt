package petproject.loskin.leonardo.presentation.ui.magazine

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.news_cell.view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.main.GoodsCategories
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerAdapter
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerViewHolder


class GoodsCategoriesAdapter(private val click: (GoodsCategories) -> Unit) : BaseRecyclerAdapter<GoodsCategories, GoodsCategoriesAdapter.Holder>() {
    override fun item(itemView: View) = Holder(itemView, click)

    override fun getItemViewType(position: Int) = R.layout.magazine_cell

    class Holder(itemView: View, val click: (GoodsCategories) -> Unit) : BaseRecyclerViewHolder<GoodsCategories>(itemView) {
        override fun bind(item: GoodsCategories) {
            itemView.setOnClickListener { click(item) }
            itemView.newsTitle.text = item.categoryName
            Glide.with(itemView.newsImage)
                    .load(item.imageUrl)
                    .into(itemView.newsImage)
        }
    }
}