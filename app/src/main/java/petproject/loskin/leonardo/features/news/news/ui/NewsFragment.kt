package petproject.loskin.leonardo.features.news.news.ui

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.base.ui.BaseFragment
import petproject.loskin.leonardo.base.ui.MainActivity
import petproject.loskin.leonardo.features.news.base.models.NewsBlock
import petproject.loskin.leonardo.features.news.news.di.DaggerNewsComponent
import petproject.loskin.leonardo.features.news.news.presenters.NewsPresenter
import petproject.loskin.leonardo.util.components.recyclerview.Utils
import javax.inject.Inject

class NewsFragment : BaseFragment(), NewsView {
    @Inject @InjectPresenter lateinit var presenter: NewsPresenter
    @ProvidePresenter fun provide() = presenter

    init {
        DaggerNewsComponent.builder()
            .navigationModule(MainActivity.ROOT)
            .build()
            .inject(this)
    }

    val adapter: NewsAdapter by lazy { NewsAdapter() }

    override fun layoutId(): Int = R.layout.recycler_view

    override fun update(items: List<NewsBlock>) {
        Utils.linearLayout(recyclerView, adapter)
        adapter.update(items)
    }
}
