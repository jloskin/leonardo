package petproject.loskin.leonardo.presentation.ui.magazine

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.SampleApplication
import petproject.loskin.leonardo.data.entity.ItemL
import petproject.loskin.leonardo.domain.main.ItemMagazine
import petproject.loskin.leonardo.domain.main.MagazineItem
import petproject.loskin.leonardo.presentation.presenter.magazine.MagazinePresenter
import petproject.loskin.leonardo.presentation.view.magazine.MagazineView
import javax.inject.Inject

class MagazineFragment : MvpAppCompatFragment(), MagazineView {
    @InjectPresenter @Inject lateinit var magazinePresenter: MagazinePresenter

    @ProvidePresenter
    fun presenter() = magazinePresenter

    init {
        SampleApplication.INSTANCE.appComponent.inject(this)
    }

    override fun nextPage(items: List<ItemMagazine>) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = downLevelAdapter.apply { update(items) }
    }

    override fun updateMagazine(items: List<MagazineItem>) {
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        recyclerView.adapter = newsAdapter.apply { update(items) }
    }

    override fun loadGoods(items: List<ItemL>) {
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = goodsAdapter.apply { update(items) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.recycler_view, null)

    private val newsAdapter: MagazineAdapter by lazy {
        MagazineAdapter(magazinePresenter::load)
    }

    private val goodsAdapter: GoodsAdapter by lazy {
        GoodsAdapter({})
    }

    private val downLevelAdapter: DownLevelAdapter by lazy {
        DownLevelAdapter(magazinePresenter::loadGoods)
    }
}