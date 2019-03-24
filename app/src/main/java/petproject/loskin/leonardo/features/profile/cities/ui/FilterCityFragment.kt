package petproject.loskin.leonardo.features.profile.cities.ui

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.base.db.dao.profile.City
import petproject.loskin.leonardo.base.ui.RootFragment
import petproject.loskin.leonardo.features.profile.cities.presenters.FilterCityPresenter
import petproject.loskin.leonardo.util.components.recyclerview.Utils
import javax.inject.Inject

class FilterCityFragment : RootFragment(), FilterCityView {
    @Inject @InjectPresenter lateinit var presenter: FilterCityPresenter
    @ProvidePresenter fun provide() = presenter

    private val adapter: FilterCityAdapter by lazy { FilterCityAdapter { } }

    override fun layoutId(): Int = R.layout.recycler_view

    override fun titleId(): Int = R.string.your_city

    override fun navigationIconId(): Int = R.drawable.abc_ic_ab_back_material

    override fun update(items: List<City>) {
        Utils.defaultList(recyclerView, adapter)
        adapter.update(items)
    }
}
