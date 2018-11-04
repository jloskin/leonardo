package petproject.loskin.leonardo.presentation.ui.magazine.categories

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
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.data.entity.magazine.MenuL
import petproject.loskin.leonardo.domain.magazine.categories.CategoriesViewModel
import petproject.loskin.leonardo.presentation.ui.MainActivity
import petproject.loskin.leonardo.presentation.ui.Screens
import ru.terrakok.cicerone.Router


class CategoriesFragment : Fragment() {
    private val viewModel: CategoriesViewModel by viewModel()
    private val router: Router by inject()

    private val adapter: CategoriesAdapter by lazy {
        CategoriesAdapter { router.navigateTo(Screens.SubCategories(it.name, it.url)) }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.recycler_view, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.categories.observe(this, Observer<List<MenuL>>(adapter::update))

        with((activity as MainActivity).toolbar) {
            title = getString(R.string.goods_catalog)
            navigationIcon = null
        }
        with(recyclerView) {
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            addItemDecoration(DividerItemDecoration(context, linearLayoutManager.orientation))
            adapter = this@CategoriesFragment.adapter
        }
    }
}