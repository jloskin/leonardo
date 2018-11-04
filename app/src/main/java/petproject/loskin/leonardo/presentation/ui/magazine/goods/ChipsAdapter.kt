package petproject.loskin.leonardo.presentation.ui.magazine.goods

import android.view.View
import kotlinx.android.synthetic.main.news_cell.view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.data.entity.magazine.MenuL
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerAdapter
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerViewHolder
import petproject.loskin.leonardo.util.GlideApp


class ChipsAdapter(
        private val click: (MenuL) -> Unit
) : BaseRecyclerAdapter<MenuL, ChipsAdapter.Holder>() {
    override fun item(itemView: View) = Holder(itemView, click)

    override fun getItemViewType(position: Int) = R.layout.chips_cell

    class Holder(itemView: View, val click: (MenuL) -> Unit) : BaseRecyclerViewHolder<MenuL>(itemView) {
        override fun bind(item: MenuL) {
            with(itemView) {
                setOnClickListener { click(item) }
                newsTitle.text = item.name
            }
        }
    }
}