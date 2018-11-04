package petproject.loskin.leonardo.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.magazine.goods.Filter
import petproject.loskin.leonardo.presentation.ui.magazine.FilterAdapter

class FilterFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.filter_fragment, container, false)

    private val filterAdapter by lazy { FilterAdapter({}) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).clearMenu()

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
