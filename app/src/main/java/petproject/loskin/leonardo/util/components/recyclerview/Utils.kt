package petproject.loskin.leonardo.util.components.recyclerview

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object Utils {
    fun <ItemType : Any, ItemHolder : BaseRecyclerViewHolder<ItemType>> linearLayout(
        recyclerView: RecyclerView,
        adapter: BaseRecyclerAdapter<ItemType, ItemHolder>,
        horizontal: Boolean = false,
        divider: Boolean = true
    ) {
        if (recyclerView.adapter == adapter) return

        with(recyclerView) {
            val linearLayoutManager =
                if (!horizontal) LinearLayoutManager(recyclerView.context)
                else LinearLayoutManager(recyclerView.context, LinearLayoutManager.HORIZONTAL, false)
            layoutManager = linearLayoutManager
            if (divider)
                addItemDecoration(DividerItemDecoration(recyclerView.context, linearLayoutManager.orientation))
            this.adapter = adapter
        }
    }

    fun <ItemType : Any, ItemHolder : BaseRecyclerViewHolder<ItemType>> gridLayout(
        recyclerView: RecyclerView,
        adapter: BaseRecyclerAdapter<ItemType, ItemHolder>,
        spanCount: Int
    ) {
        if (recyclerView.adapter == adapter) return

        with(recyclerView) {
            layoutManager = GridLayoutManager(context, spanCount)
            this.adapter = adapter
        }
    }
}