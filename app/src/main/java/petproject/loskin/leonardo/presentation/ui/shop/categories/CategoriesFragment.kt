package petproject.loskin.leonardo.presentation.ui.shop.categories

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.data.entity.shop.MenuL
import petproject.loskin.leonardo.domain.model.shop.categories.CategoriesViewModel
import petproject.loskin.leonardo.presentation.ui.Screens
import petproject.loskin.leonardo.presentation.ui.base.RootFragment

class CategoriesFragment : RootFragment() {
    private val viewModel: CategoriesViewModel by viewModel()
    private val adapter: CategoriesAdapter by lazy { CategoriesAdapter { router.navigateTo(Screens.SubCategories(it.name, it.url)) } }

    override fun titleId(): Int = R.string.goods_catalog

    override fun layoutId(): Int = R.layout.recycler_view

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.categories.observe(this, Observer<List<MenuL>>(adapter::update))
        mainActivity.setMenu(R.menu.categories, {
            when (it?.itemId) {
                R.id.city -> {
                    router.navigateTo(Screens.FilterCity())
                    true
                }
                else -> false
            }
        })
        with(recyclerView) {
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            addItemDecoration(DividerItemDecoration(context, linearLayoutManager.orientation))
            adapter = this@CategoriesFragment.adapter
        }
    }
}