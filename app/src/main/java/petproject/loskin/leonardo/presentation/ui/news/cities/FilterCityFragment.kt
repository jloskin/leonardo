package petproject.loskin.leonardo.presentation.ui.news.cities

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.data.mapper.magazine.categories.City
import petproject.loskin.leonardo.presentation.ui.base.BaseFragment

class FilterCityFragment : BaseFragment() {
    private val viewModel: FilterCityViewModel by viewModel()
    private val adapter: FilterCityAdapter by lazy { FilterCityAdapter { } }

    override fun layoutId(): Int = R.layout.recycler_view

    override fun titleId(): Int = R.string.your_city

    override fun navigationIconId(): Int = R.drawable.abc_ic_ab_back_material

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.cities.observe(this, Observer<List<City>>(adapter::update))
        with(recyclerView) {
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            addItemDecoration(DividerItemDecoration(context, linearLayoutManager.orientation))
            adapter = this@FilterCityFragment.adapter
        }
    }
}
