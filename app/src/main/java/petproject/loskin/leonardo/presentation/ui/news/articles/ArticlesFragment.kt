package petproject.loskin.leonardo.presentation.ui.news.articles

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.model.news.articles.ArticlesViewModel
import petproject.loskin.leonardo.presentation.ui.base.BaseFragment

class ArticlesFragment : BaseFragment() {
  override fun layoutId(): Int = R.layout.recycler_view

  private val viewModel: ArticlesViewModel by viewModel()

  val adapter: ArticlesAdapter by lazy { ArticlesAdapter() }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel.articles().subscribe(adapter::update, Throwable::printStackTrace)
    with(recyclerView) {
      val linearLayoutManager = LinearLayoutManager(context)
      layoutManager = linearLayoutManager
      addItemDecoration(DividerItemDecoration(context, linearLayoutManager.orientation))
      adapter = this@ArticlesFragment.adapter
    }
  }
}
