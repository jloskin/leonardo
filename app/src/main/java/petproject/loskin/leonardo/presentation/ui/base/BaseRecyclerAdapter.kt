package petproject.loskin.leonardo.presentation.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter

abstract class BaseRecyclerAdapter<B, C : BaseRecyclerViewHolder<B>> : Adapter<C>() {
    private val mutableList: MutableList<B> = mutableListOf()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): C = item(LayoutInflater.from(p0.context).inflate(p1, p0, false))

    abstract fun item(itemView: View): C

    override fun getItemCount(): Int = mutableList.size

    override fun onBindViewHolder(p0: C, p1: Int) {
        p0.bind(mutableList[p1])
    }

    fun update(item: List<B>) {
        mutableList.clear()
        mutableList.addAll(item)
        notifyDataSetChanged()
    }
}