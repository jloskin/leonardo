package petproject.loskin.leonardo.presentation.ui.news

import androidx.fragment.app.Fragment
import petproject.loskin.leonardo.data.entity.news.NewsBlock
import petproject.loskin.leonardo.presentation.presenter.news.NewsPresenter


class NewsFragment : Fragment() {
    lateinit var newsPresenter: NewsPresenter

    val adapter: NewsAdapter by lazy { NewsAdapter() }

    fun updateNews(item: List<NewsBlock>) {
        adapter.update(item)
    }
}
