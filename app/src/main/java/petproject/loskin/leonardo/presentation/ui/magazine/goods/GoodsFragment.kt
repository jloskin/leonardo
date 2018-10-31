package petproject.loskin.leonardo.presentation.ui.magazine.goods

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.magazine.goods.GoodsViewModel
import petproject.loskin.leonardo.presentation.ui.MainActivity

class GoodsFragment : Fragment() {
    private val viewModel: GoodsViewModel by viewModel()

    private val adapter: GoodsAdapter by lazy { GoodsAdapter {} }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.recycler_view, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(GOODS_LINK)
                ?.let(viewModel::loadGoods)
                ?.subscribe(adapter::update, Throwable::printStackTrace)

        with((activity as MainActivity).toolbar) {
            title = arguments?.getString(SUBCATEGORY_TITLE)
            navigationIcon = VectorDrawableCompat.create(resources, R.drawable.abc_ic_ab_back_material, null)
        }

        with(recyclerView) {
            layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, 2)
            adapter = this@GoodsFragment.adapter
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