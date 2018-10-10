package petproject.loskin.leonardo.presentation.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.main.ItemMagazine
import petproject.loskin.leonardo.presentation.ui.magazine.DownLevelAdapter
import petproject.loskin.leonardo.presentation.ui.magazine.GoodsCategoriesFragment
import petproject.loskin.leonardo.presentation.ui.magazine.GoodsComponentHandler
import javax.inject.Inject

class GoodsSubCategoriesFragment : MvpAppCompatFragment(), GoodsSubCategoriesView {
    @InjectPresenter
    @Inject
    lateinit var presenter: GoodsSubCategoriesPresenter

    init {
        GoodsComponentHandler.goodsComponent.inject(this)
    }

    @ProvidePresenter
    fun presenter() = presenter

    private val adapter: DownLevelAdapter by lazy {
        DownLevelAdapter {

        }
    }

    override fun loadPage(items: List<ItemMagazine>) {
        adapter.update(items)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = this@GoodsSubCategoriesFragment.adapter
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        arguments?.getString(GoodsCategoriesFragment.CATEGORY_LINK)?.let(presenter::listPage)
        return inflater.inflate(R.layout.recycler_view, null)
    }
}
