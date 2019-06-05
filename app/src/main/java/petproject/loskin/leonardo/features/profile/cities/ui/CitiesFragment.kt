package petproject.loskin.leonardo.features.profile.cities.ui

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.base.db.dao.profile.City
import petproject.loskin.leonardo.base.ui.MainActivity
import petproject.loskin.leonardo.base.ui.RootFragment
import petproject.loskin.leonardo.features.profile.cities.di.DaggerCitiesComponent
import petproject.loskin.leonardo.features.profile.cities.presenters.CitiesPresenter
import petproject.loskin.leonardo.util.components.recyclerview.Utils
import javax.inject.Inject

class CitiesFragment : RootFragment(), CitiesView {
    @Inject lateinit var presenterLazy: dagger.Lazy<CitiesPresenter>
    @InjectPresenter lateinit var presenter: CitiesPresenter
    @ProvidePresenter fun provide(): CitiesPresenter {
        DaggerCitiesComponent.builder().navigationModule(MainActivity.ROOT).build().inject(this)
        return presenterLazy.get()
    }

    private val adapter: CitiesAdapter by lazy { CitiesAdapter { } }

    override fun layoutId(): Int = R.layout.recycler_view

    override fun titleId(): Int = R.string.your_city

    override fun navigationIconId(): Int = R.drawable.abc_ic_ab_back_material

    override fun update(items: List<City>) {
        Utils.linearLayout(recyclerView, adapter)
        adapter.update(items)
    }
}
