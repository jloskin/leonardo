package petproject.loskin.leonardo.presentation.ui.magazine

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.filter_box.view.*
import kotlinx.android.synthetic.main.filter_cell.view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.magazine.goods.Filter
import petproject.loskin.leonardo.domain.magazine.goods.FilterEntity
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerAdapter
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerViewHolder


class FilterAdapter(
        private val click: (Filter) -> Unit
) : BaseRecyclerAdapter<Filter, FilterAdapter.Holder>() {
    override fun item(itemView: View) = Holder(itemView, click)

    override fun getItemViewType(position: Int) = R.layout.filter_cell

    class Holder(itemView: View, val click: (Filter) -> Unit) : BaseRecyclerViewHolder<Filter>(itemView) {
        private val filterAdapter by lazy { FilterAdapter({}) }

        override fun bind(item: Filter) {
            with(itemView) {
                setOnClickListener { click(item) }
                title.text = item.id
                title.setOnClickListener {
                    val invisible = bottom_view.visibility == GONE
                    bottom_view.visibility = if (invisible) VISIBLE else GONE
                    expand.setImageResource(
                            if (invisible) R.drawable.ic_collapse_button
                            else R.drawable.ic_expand_button
                    )
                }
                with(bottom_view) {
                    val linearLayoutManager = LinearLayoutManager(context)
                    layoutManager = linearLayoutManager
                    adapter = filterAdapter.also { it.update(item.parentId) }
                }
            }
        }
    }

    class FilterAdapter(
            private val click: (FilterEntity) -> Unit
    ) : BaseRecyclerAdapter<FilterEntity, FilterAdapter.Holder>() {
        override fun item(itemView: View) = Holder(itemView, click)

        override fun getItemViewType(position: Int) = R.layout.filter_box

        class Holder(itemView: View, val click: (FilterEntity) -> Unit) : BaseRecyclerViewHolder<FilterEntity>(itemView) {
            override fun bind(item: FilterEntity) {
                with(itemView) {
                    setOnClickListener { click(item) }
                    checkbox.text = item.description
                }
            }
        }
    }
}