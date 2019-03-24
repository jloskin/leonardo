package petproject.loskin.leonardo.features.shop.categories.ui

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.base.db.dao.shop.MenuL
import petproject.loskin.leonardo.base.ui.RootFragment
import petproject.loskin.leonardo.features.Screens
import petproject.loskin.leonardo.features.shop.categories.di.DaggerCategoriesComponent
import petproject.loskin.leonardo.features.shop.categories.presenters.CategoriesPresenter
import petproject.loskin.leonardo.util.components.recyclerview.Utils
import javax.inject.Inject

class CategoriesFragment : RootFragment(), CategoriesView {
    @Inject @InjectPresenter lateinit var presenter: CategoriesPresenter
    @ProvidePresenter fun provide() = presenter

    init {
        DaggerCategoriesComponent.create().inject(this)
    }

    private val adapter: CategoriesAdapter by lazy { CategoriesAdapter { router.navigateTo(Screens.SubCategories(it.name, it.url)) } }

    override fun titleId(): Int = R.string.goods_catalog

    override fun layoutId(): Int = R.layout.recycler_view

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity.setMenu(R.menu.categories, {
            when (it.itemId) {
                R.id.city -> {
                    router.navigateTo(Screens.FilterCity())
                    true
                }
                else -> false
            }
        })
    }

    override fun setValue(list: List<MenuL>) {
        Utils.defaultList(recyclerView, adapter)
        adapter.update(list)
    }
}