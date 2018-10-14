package petproject.loskin.leonardo.presentation.ui.mclasses

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.news_cell.view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.data.entity.competitions.CompetitionsBlock
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerAdapter
import petproject.loskin.leonardo.presentation.ui.base.BaseRecyclerViewHolder
import petproject.loskin.leonardo.util.GlideApp


class MClassesAdapter : BaseRecyclerAdapter<CompetitionsBlock, MClassesAdapter.Holder>() {
    override fun item(itemView: View) = Holder(itemView)

    override fun getItemViewType(position: Int) = R.layout.news_cell

    class Holder(itemView: View) : BaseRecyclerViewHolder<CompetitionsBlock>(itemView) {
        override fun bind(item: CompetitionsBlock) {
            itemView.newsTitle.text = item.titleName
            itemView.newsDescription.text = item.text
            var requestOptions = RequestOptions()
            requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(8))
            GlideApp.with(itemView.newsImage)
                    .load(item.imgUrl)
                    .apply(requestOptions)
                    .into(itemView.newsImage)
        }
    }
}