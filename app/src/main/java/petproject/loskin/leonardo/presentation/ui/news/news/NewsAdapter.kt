package petproject.loskin.leonardo.presentation.ui.news.news

import android.view.View
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.news_cell.view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.data.entity.news.NewsBlock
import petproject.loskin.leonardo.util.GlideApp
import petproject.loskin.leonardo.util.components.recyclerview.BaseRecyclerAdapter
import petproject.loskin.leonardo.util.components.recyclerview.BaseRecyclerViewHolder


class NewsAdapter : BaseRecyclerAdapter<NewsBlock, NewsAdapter.Holder>() {
  override fun item(itemView: View) = Holder(itemView)

  override fun getItemViewType(position: Int) = R.layout.news_cell

  class Holder(itemView: View) : BaseRecyclerViewHolder<NewsBlock>(itemView) {
    override fun bind(item: NewsBlock) {
      itemView.newsTitle.text = item.titleName
      itemView.newsDescription.text = item.text
      GlideApp.with(itemView.newsImage)
        .load(item.imgUrl)
        .apply(RequestOptions().transforms(CenterCrop(), RoundedCorners(8)))
        .into(itemView.newsImage)
    }
  }
}