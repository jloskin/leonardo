package petproject.loskin.leonardo.features.shop.goods.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.goods_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.base.ui.RootFragment
import petproject.loskin.leonardo.features.Screens
import petproject.loskin.leonardo.features.shop.goods.presenters.GoodsPresenter
import javax.inject.Inject

class GoodsFragment : RootFragment(), GoodsView {
    @Inject @InjectPresenter lateinit var presenter: GoodsPresenter
    @ProvidePresenter fun provide() = presenter

    private val adapter: GoodsAdapter by lazy { GoodsAdapter {} }
    private val chipsAdapter: ChipsAdapter by lazy { ChipsAdapter {} }

    override fun title(): String = arguments?.getString(SUBCATEGORY_TITLE) ?: ""

    override fun layoutId(): Int = R.layout.goods_view

    override fun navigationIconId(): Int = R.drawable.abc_ic_ab_back_material

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getString(GOODS_LINK)?.let(presenter::loadGoods)
        presenter.chips.observe(this, Observer(chipsAdapter::update))
        presenter.goods.observe(this, Observer(adapter::update))

        presenter.filters.observe(this, Observer { filters ->
            mainActivity.setMenu(R.menu.goods, {
                when (it.itemId) {
                    R.id.filter -> {
                        router.navigateTo(Screens.FilterScreen(filters))
                        true
                    }
                    else -> false
                }
            })
        })
        with(goods) {
            layoutManager = GridLayoutManager(context, 2)
            adapter = this@GoodsFragment.adapter
        }
        with(chips) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = this@GoodsFragment.chipsAdapter
        }
    }

    companion object {
        private const val GOODS_LINK = "LINK"
        private const val SUBCATEGORY_TITLE = "TITLE"

        fun instance(title: String, link: String): GoodsFragment =
            GoodsFragment().apply {
                arguments = Bundle().apply {
                    putString(GOODS_LINK, link)
                    putString(SUBCATEGORY_TITLE, title)
                }
            }
    }
}