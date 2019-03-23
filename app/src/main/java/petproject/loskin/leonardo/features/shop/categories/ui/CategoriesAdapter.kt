package petproject.loskin.leonardo.features.shop.categories.ui

import android.view.View
import kotlinx.android.synthetic.main.news_cell.view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.base.db.dao.shop.MenuL
import petproject.loskin.leonardo.util.components.recyclerview.BaseRecyclerAdapter
import petproject.loskin.leonardo.util.components.recyclerview.BaseRecyclerViewHolder
import petproject.loskin.leonardo.util.glide.GlideApp

class CategoriesAdapter(
  private val click: (MenuL) -> Unit
) : BaseRecyclerAdapter<MenuL, CategoriesAdapter.Holder>() {
  override fun item(itemView: View) = Holder(itemView, click)

  override fun getItemViewType(position: Int) = R.layout.magazine_cell

  class Holder(itemView: View, val click: (MenuL) -> Unit) : BaseRecyclerViewHolder<MenuL>(itemView) {
    override fun bind(item: MenuL) {
      with(itemView) {
        setOnClickListener { click(item) }
        newsTitle.text = item.name
        GlideApp.with(newsImage)
          .load(item.image())
          .placeholder(R.drawable.ic_leonardo_logo)
          .circleCrop().into(newsImage)
      }
    }
  }
}