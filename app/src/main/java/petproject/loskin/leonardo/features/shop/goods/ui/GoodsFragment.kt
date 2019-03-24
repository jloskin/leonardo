package petproject.loskin.leonardo.features.shop.goods.ui

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.goods_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.base.db.dao.shop.MenuL
import petproject.loskin.leonardo.base.ui.MainActivity
import petproject.loskin.leonardo.base.ui.RootFragment
import petproject.loskin.leonardo.features.Screens
import petproject.loskin.leonardo.features.shop.goods.di.DaggerGoodsComponent
import petproject.loskin.leonardo.features.shop.goods.di.GoodsModule
import petproject.loskin.leonardo.features.shop.goods.features.filters.models.Filter
import petproject.loskin.leonardo.features.shop.goods.models.GoodsData
import petproject.loskin.leonardo.features.shop.goods.presenters.GoodsPresenter
import petproject.loskin.leonardo.util.components.recyclerview.Utils
import javax.inject.Inject

class GoodsFragment : RootFragment(), GoodsView {
    @Inject @InjectPresenter lateinit var presenter: GoodsPresenter
    @ProvidePresenter fun provide() = presenter

    private val adapter: GoodsAdapter by lazy { GoodsAdapter {} }
    private val chipsAdapter: ChipsAdapter by lazy { ChipsAdapter {} }

    override fun title(): String = arguments?.getString(SUBCATEGORY_TITLE) ?: ""

    override fun layoutId(): Int = R.layout.goods_view

    override fun navigationIconId(): Int = R.drawable.abc_ic_ab_back_material

    override fun updateMenu(items: List<MenuL>) {
        Utils.linearLayout(chips, chipsAdapter, true, divider = false)
        chipsAdapter.update(items)
    }

    override fun updateGoods(items: List<GoodsData>) {
        Utils.gridLayout(goods, adapter, 2)
        adapter.update(items)
    }

    override fun updateFilters(items: List<Filter>) {
        mainActivity.setMenu(R.menu.goods, {
            when (it.itemId) {
                R.id.filter -> {
                    router.navigateTo(Screens.FilterScreen(items))
                    true
                }
                else -> false
            }
        })
    }

    companion object {
        private const val SUBCATEGORY_TITLE = "TITLE"

        fun instance(title: String, link: String): GoodsFragment =
            GoodsFragment().apply {
                arguments = Bundle().apply {
                    putString(SUBCATEGORY_TITLE, title)
                }
            }.also {
                DaggerGoodsComponent.builder()
                    .goodsModule(GoodsModule(link))
                    .navigationModule(MainActivity.ROOT)
                    .build()
                    .inject(it)
            }
    }
}