package petproject.loskin.leonardo.util.components.recyclerview

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object Utils {
  fun <ItemType : Any, ItemHolder : BaseRecyclerViewHolder<ItemType>> defaultList(
    recyclerView: RecyclerView,
    adapter: BaseRecyclerAdapter<ItemType, ItemHolder>
  ) {
    if (recyclerView.adapter == adapter) return

    with(recyclerView) {
      val linearLayoutManager = LinearLayoutManager(recyclerView.context)
      layoutManager = linearLayoutManager
      addItemDecoration(DividerItemDecoration(recyclerView.context, linearLayoutManager.orientation))
      this.adapter = adapter
    }
  }
}