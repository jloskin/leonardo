package petproject.loskin.leonardo.presentation.ui.base

import android.view.View

abstract class BaseRecyclerViewHolder<Z>(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: Z)
}