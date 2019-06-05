package petproject.loskin.leonardo.features.shop.goods.features.filters.ui

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.base.ui.RootFragment
import petproject.loskin.leonardo.features.shop.goods.features.filters.models.Filter
import petproject.loskin.leonardo.util.components.recyclerview.Utils

class FilterFragment : RootFragment() {
    private val arrayOfParcelables: List<Filter>
        get() = (arguments?.getParcelableArray(FILTER_ITEMS) as? Array<Filter>)?.toList() ?: throw RuntimeException()

    private val filterAdapter by lazy { FilterAdapter({}) }

    override fun layoutId(): Int = R.layout.filter_fragment

    override fun titleId(): Int = R.string.filter

    override fun navigationIconId(): Int = R.drawable.abc_ic_ab_back_material

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Utils.linearLayout(recyclerView, filterAdapter.also { it.update(arrayOfParcelables) })
    }

    companion object {
        private const val FILTER_ITEMS: String = "ITEMS"

        fun instance(filters: List<Filter>): FilterFragment =
            FilterFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArray(FILTER_ITEMS, filters.toTypedArray())
                }
            }
    }
}
