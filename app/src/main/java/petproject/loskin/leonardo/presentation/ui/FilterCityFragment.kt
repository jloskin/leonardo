package petproject.loskin.leonardo.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.data.mapper.magazine.categories.City

class FilterCityFragment : Fragment() {
    private val viewModel: FilterCityViewModel by viewModel()

    private val adapter: FilterCityAdapter by lazy { FilterCityAdapter { } }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.recycler_view, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.cities.observe(this, Observer<List<City>>(adapter::update))

        val mainActivity = activity as MainActivity
        with(mainActivity.toolbar) {
            title = getString(R.string.goods_catalog)
            navigationIcon = null
        }
        mainActivity.clearMenu()
        with(recyclerView) {
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            addItemDecoration(DividerItemDecoration(context, linearLayoutManager.orientation))
            adapter = this@FilterCityFragment.adapter
        }
    }
}
