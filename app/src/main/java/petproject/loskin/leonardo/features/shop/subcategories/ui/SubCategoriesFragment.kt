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
    @Inject lateinit var presenterLazy: dagger.Lazy<SubCategoriesPresenter>
    @InjectPresenter lateinit var presenter: SubCategoriesPresenter
    @ProvidePresenter fun provide(): SubCategoriesPresenter {
        DaggerSubCategoriesComponent.builder().subCategoriesModule(SubCategoriesModule(link)).navigationModule(MainActivity.ROOT).build().inject(this)
        return presenterLazy.get()
    }

    private val title: String
        get() = arguments?.getString(SUBCATEGORY_TITLE) ?: throw RuntimeException()

    private val link: String
        get() = arguments?.getString(LINK) ?: throw RuntimeException()

    private val adapter: CategoriesAdapter by lazy {
        CategoriesAdapter { router.navigateTo(Screens.GoodsFragmentScreen(it.name, it.url)) }
    }

    override fun layoutId(): Int = R.layout.recycler_view

    override fun title(): String = title

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
        private const val LINK = "LINK"

        fun instance(title: String, link: String): SubCategoriesFragment =
            SubCategoriesFragment().apply {
                arguments = Bundle().apply {
                    putString(SUBCATEGORY_TITLE, title)
                    putString(LINK, link)
                }
            }
    }
}
