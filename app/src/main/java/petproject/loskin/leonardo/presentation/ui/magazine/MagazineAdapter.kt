package petproject.loskin.leonardo.presentation.ui.magazine

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.news_cell.view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.main.MagazineItem
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerAdapter
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerViewHolder


class MagazineAdapter(private val click: (MagazineItem) -> Unit) : BaseRecyclerAdapter<MagazineItem, MagazineAdapter.Holder>() {
    override fun item(itemView: View) = Holder(itemView, click)

    override fun getItemViewType(position: Int) = R.layout.magazine_cell

    class Holder(itemView: View, val click: (MagazineItem) -> Unit) : BaseRecyclerViewHolder<MagazineItem>(itemView) {
        override fun bind(item: MagazineItem) {
            itemView.setOnClickListener { click(item) }
            itemView.newsTitle.text = item.categoryName
            Glide.with(itemView.newsImage)
                    .load(item.imageUrl)
                    .into(itemView.newsImage)
        }
    }
}