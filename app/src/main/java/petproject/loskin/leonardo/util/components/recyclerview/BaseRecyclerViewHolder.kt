package petproject.loskin.leonardo.util.components.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class BaseRecyclerViewHolder<Z>(itemView: View) : ViewHolder(itemView) {
    abstract fun bind(item: Z)
}