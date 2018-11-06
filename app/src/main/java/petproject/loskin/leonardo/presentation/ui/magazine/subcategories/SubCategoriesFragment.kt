package petproject.loskin.leonardo.presentation.ui.magazine.subcategories

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.data.entity.magazine.MenuL
import petproject.loskin.leonardo.domain.magazine.subcategories.SubCategoriesViewModel
import petproject.loskin.leonardo.presentation.ui.Screens
import petproject.loskin.leonardo.presentation.ui.base.BaseFragment
import petproject.loskin.leonardo.presentation.ui.magazine.categories.CategoriesAdapter

class SubCategoriesFragment : BaseFragment() {
    private val presenter: SubCategoriesViewModel by viewModel()
    private val adapter: CategoriesAdapter by lazy {
        CategoriesAdapter { router.navigateTo(Screens.GoodsFragmentScreen(it.name, it.url)) }
    }

    override fun layoutId(): Int = R.layout.recycler_view

    override fun title(): String = arguments?.getString(SUBCATEGORY_TITLE) ?: ""

    override fun navigationIconId(): Int? = R.drawable.abc_ic_ab_back_material

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(SUBCATEGORY_LINK)?.let(presenter::loadSubCategories)
        presenter.subCategories.observe(this, Observer<List<MenuL>>(adapter::update))

        mainActivity.setMenu(R.menu.info, {
            when (it?.itemId) {
                R.id.info -> true
                else -> false
            }
        })

        with(recyclerView) {
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            addItemDecoration(DividerItemDecoration(context, linearLayoutManager.orientation))
            adapter = this@SubCategoriesFragment.adapter
        }
    }

    companion object {
        private const val SUBCATEGORY_LINK = "LINK"
        private const val SUBCATEGORY_TITLE = "TITLE"

        fun instance(title: String, link: String): SubCategoriesFragment =
                SubCategoriesFragment().apply {
                    arguments = Bundle().apply {
                        putString(SUBCATEGORY_LINK, link)
                        putString(SUBCATEGORY_TITLE, title)
                    }
                }
    }
}
