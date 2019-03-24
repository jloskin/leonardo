package petproject.loskin.leonardo.features.shop.subcategories.ui

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.base.db.dao.shop.MenuL
import petproject.loskin.leonardo.base.ui.MainActivity
import petproject.loskin.leonardo.base.ui.RootFragment
import petproject.loskin.leonardo.features.Screens
import petproject.loskin.leonardo.features.shop.categories.ui.CategoriesAdapter
import petproject.loskin.leonardo.features.shop.subcategories.di.DaggerSubCategoriesComponent
import petproject.loskin.leonardo.features.shop.subcategories.di.SubCategoriesModule
import petproject.loskin.leonardo.features.shop.subcategories.presenters.SubCategoriesPresenter
import petproject.loskin.leonardo.util.components.recyclerview.Utils
import javax.inject.Inject

class SubCategoriesFragment : RootFragment(), SubCategoriesView {
    @Inject @InjectPresenter lateinit var presenter: SubCategoriesPresenter
    @ProvidePresenter fun provide() = presenter

    private val adapter: CategoriesAdapter by lazy {
        CategoriesAdapter { router.navigateTo(Screens.GoodsFragmentScreen(it.name, it.url)) }
    }

    override fun layoutId(): Int = R.layout.recycler_view

    override fun title(): String = arguments?.getString(SUBCATEGORY_TITLE) ?: ""

    override fun navigationIconId(): Int = R.drawable.abc_ic_ab_back_material

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivity.setMenu(R.menu.info, {
            when (it.itemId) {
                R.id.info -> true
                else -> false
            }
        })

        Utils.linearLayout(recyclerView, adapter)
    }

    override fun update(list: List<MenuL>) {
        adapter.update(list)
    }

    companion object {
        private const val SUBCATEGORY_TITLE = "TITLE"

        fun instance(title: String, link: String): SubCategoriesFragment =
            SubCategoriesFragment().apply {
                arguments = Bundle().apply {
                    putString(SUBCATEGORY_TITLE, title)
                }
            }.also {
                DaggerSubCategoriesComponent.builder()
                    .subCategoriesModule(SubCategoriesModule(link))
                    .navigationModule(MainActivity.ROOT)
                    .build()
                    .inject(it)
            }
    }
}
