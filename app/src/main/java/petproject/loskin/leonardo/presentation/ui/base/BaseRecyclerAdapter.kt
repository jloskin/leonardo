package petproject.loskin.leonardo.presentation.ui.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
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
        val calculateDiff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                    mutableList[oldItemPosition] == item[newItemPosition]

            override fun getOldListSize(): Int = mutableList.size

            override fun getNewListSize(): Int = item.size

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
                    mutableList[oldItemPosition] == item[newItemPosition]

        })
        mutableList.clear()
        mutableList.addAll(item)
        calculateDiff.dispatchUpdatesTo(this)
    }
}