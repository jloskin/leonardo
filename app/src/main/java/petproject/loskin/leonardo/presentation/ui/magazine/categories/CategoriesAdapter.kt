package petproject.loskin.leonardo.presentation.ui.magazine.categories

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.news_cell.view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.data.entity.magazine.CategoriesData
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerAdapter
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerViewHolder
import petproject.loskin.leonardo.util.GlideApp


class CategoriesAdapter(
        private val click: (CategoriesData) -> Unit
) : BaseRecyclerAdapter<CategoriesData, CategoriesAdapter.Holder>() {
    override fun item(itemView: View) = Holder(itemView, click)

    override fun getItemViewType(position: Int) = R.layout.magazine_cell

    class Holder(itemView: View, val click: (CategoriesData) -> Unit) : BaseRecyclerViewHolder<CategoriesData>(itemView) {
        override fun bind(item: CategoriesData) {
            with(itemView) {
                setOnClickListener { click(item) }
                newsTitle.text = item.categoryName
                GlideApp.with(newsImage).load(item.imageUrl).into(newsImage)
            }
        }
    }
}