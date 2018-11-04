package petproject.loskin.leonardo.presentation.ui.magazine.subcategories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.data.entity.magazine.MenuL
import petproject.loskin.leonardo.domain.magazine.subcategories.SubCategoriesViewModel
import petproject.loskin.leonardo.presentation.ui.MainActivity
import petproject.loskin.leonardo.presentation.ui.Screens
import petproject.loskin.leonardo.presentation.ui.magazine.categories.CategoriesAdapter
import ru.terrakok.cicerone.Router

class SubCategoriesFragment : Fragment() {
    private val presenter: SubCategoriesViewModel by viewModel()
    private val router: Router by inject()

    private val adapter: CategoriesAdapter by lazy {
        CategoriesAdapter { router.navigateTo(Screens.GoodsFragmentScreen(it.name, it.url)) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(SUBCATEGORY_LINK)?.let(presenter::loadSubCategories)
        presenter.subCategories.observe(this, Observer<List<MenuL>>(adapter::update))

        val mainActivity = activity as MainActivity
        with(mainActivity.toolbar) {
            title = arguments?.getString(SUBCATEGORY_TITLE)
            navigationIcon = VectorDrawableCompat.create(resources, R.drawable.abc_ic_ab_back_material, null)
        }
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

    override fun onPause() {
        (activity as MainActivity).clearMenu()
        super.onPause()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.recycler_view, container, false)

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
