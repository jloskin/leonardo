package petproject.loskin.leonardo.util.components.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter

abstract class BaseRecyclerAdapter<B, C : BaseRecyclerViewHolder<B>> : Adapter<C>() {
    private val mutableList: MutableList<B> = mutableListOf()

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        layoutId: Int
    ): C = item(
        LayoutInflater.from(viewGroup.context).inflate(layoutId, viewGroup, false)
    )

    abstract fun item(itemView: View): C

    override fun getItemCount(): Int = mutableList.size

    override fun onBindViewHolder(
        holder: C,
        position: Int
    ) {
        holder.bind(mutableList[position])
    }

    fun update(item: Collection<B>) {
        mutableList.clear()
        mutableList.addAll(item)
        notifyDataSetChanged()
    }
}