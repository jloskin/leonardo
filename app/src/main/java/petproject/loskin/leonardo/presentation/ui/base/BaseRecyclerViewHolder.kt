package petproject.loskin.leonardo.presentation.ui.base

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseRecyclerViewHolder<Z>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: Z)
}