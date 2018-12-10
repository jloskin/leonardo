package petproject.loskin.leonardo.presentation.ui.shop.filters

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.model.shop.goods.Filter
import petproject.loskin.leonardo.presentation.ui.base.RootFragment

class FilterFragment : RootFragment() {
  private val filterAdapter by lazy { FilterAdapter({}) }

  override fun layoutId(): Int = R.layout.filter_fragment

  override fun titleId(): Int = R.string.filter

  override fun navigationIconId(): Int = R.drawable.abc_ic_ab_back_material

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    arguments?.getParcelableArray(FILTER_ITEMS)?.let { (it as Array<Filter>).toList() }?.let { items ->
      with(recyclerView) {
        val linearLayoutManager = LinearLayoutManager(context)
        layoutManager = linearLayoutManager
        adapter = filterAdapter.also { it.update(items) }
        addItemDecoration(DividerItemDecoration(context, linearLayoutManager.orientation))
      }
    }
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
