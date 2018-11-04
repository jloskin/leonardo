package petproject.loskin.leonardo.presentation.ui.magazine.goods

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.goods_view.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.magazine.goods.GoodsViewModel
import petproject.loskin.leonardo.presentation.ui.MainActivity
import petproject.loskin.leonardo.presentation.ui.Screens
import ru.terrakok.cicerone.Router

class GoodsFragment : Fragment() {
    private val viewModel: GoodsViewModel by viewModel()
    private val router: Router by inject()

    private val adapter: GoodsAdapter by lazy { GoodsAdapter {} }
    private val chipsAdapter: ChipsAdapter by lazy { ChipsAdapter {} }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.goods_view, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = activity as MainActivity

        arguments?.getString(GOODS_LINK)?.let(viewModel::loadGoods)
        viewModel.chips.observe(this, Observer(chipsAdapter::update))
        viewModel.goods.observe(this, Observer(adapter::update))

        viewModel.filters.observe(this, Observer { filters ->
            mainActivity.setMenu(R.menu.goods, {
                when (it?.itemId) {
                    R.id.filter -> {
                        router.navigateTo(Screens.FilterScreen(filters))
                        true
                    }
                    else -> false
                }
            })
        })

        with(mainActivity.toolbar) {
            title = arguments?.getString(SUBCATEGORY_TITLE)
            navigationIcon = VectorDrawableCompat.create(resources, R.drawable.abc_ic_ab_back_material, null)
        }
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