package petproject.loskin.leonardo.util.components.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter

abstract class BaseRecyclerAdapter<B, C : BaseRecyclerViewHolder<B>> : Adapter<C>() {
  private val mutableList: MutableList<B> = mutableListOf()

  override fun onCreateViewHolder(p0: ViewGroup, p1: Int): C = item(LayoutInflater.from(p0.context).inflate(p1, p0, false))

  abstract fun item(itemView: View): C

  override fun getItemCount(): Int = mutableList.size

  override fun onBindViewHolder(holder: C, position: Int) {
    holder.bind(mutableList[position])
  }

  fun update(item: List<B>) {
    mutableList.clear()
    mutableList.addAll(item)
    notifyDataSetChanged()
  }
}