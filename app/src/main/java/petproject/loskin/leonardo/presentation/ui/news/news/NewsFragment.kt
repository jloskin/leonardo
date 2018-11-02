package petproject.loskin.leonardo.presentation.ui.news.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.presentation.presenter.news.NewsViewModel
import petproject.loskin.leonardo.presentation.ui.MainActivity


class NewsFragment : Fragment() {
    private val newsViewModel: NewsViewModel by viewModel()

    val adapter: NewsAdapter by lazy { NewsAdapter() }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.recycler_view, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsViewModel.news().subscribe(adapter::update, Throwable::printStackTrace)

        (activity as MainActivity).toolbar.title = getString(R.string.news)

        with(recyclerView) {
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            addItemDecoration(DividerItemDecoration(context, linearLayoutManager.orientation))
            adapter = this@NewsFragment.adapter
        }
    }
}
