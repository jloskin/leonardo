package petproject.loskin.leonardo.presentation.ui.news.news

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.model.news.NewsViewModel
import petproject.loskin.leonardo.presentation.ui.base.BaseFragment


class NewsFragment : BaseFragment() {
    override fun layoutId(): Int = R.layout.recycler_view

    private val newsViewModel: NewsViewModel by viewModel()

    override fun titleId(): Int = R.string.news

    val adapter: NewsAdapter by lazy { NewsAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViewModel.news().subscribe(adapter::update, Throwable::printStackTrace)
        with(recyclerView) {
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            addItemDecoration(DividerItemDecoration(context, linearLayoutManager.orientation))
            adapter = this@NewsFragment.adapter
        }
    }
}
