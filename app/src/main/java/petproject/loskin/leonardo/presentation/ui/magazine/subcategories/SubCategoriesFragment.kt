package petproject.loskin.leonardo.presentation.ui.magazine.subcategories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.magazine.subcategories.SubCategoriesViewModel
import petproject.loskin.leonardo.presentation.ui.Screens
import ru.terrakok.cicerone.Router

class SubCategoriesFragment : Fragment() {
    private val presenter: SubCategoriesViewModel by viewModel()
    private val router: Router by inject()

    private val adapter: SubCategoriesAdapter by lazy {
        SubCategoriesAdapter { router.navigateTo(Screens.GoodsFragmentScreen(it.itemUrl)) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(SUBCATEGORY_LINK)
                ?.let(presenter::loadSubCategories)
                ?.subscribe(adapter::update, Throwable::printStackTrace)

        with(recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = this@SubCategoriesFragment.adapter
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.recycler_view, container, false)

    companion object {
        private const val SUBCATEGORY_LINK = "LINK"

        fun instance(link: String): SubCategoriesFragment =
                SubCategoriesFragment().apply {
                    arguments = Bundle().apply {
                        putString(SUBCATEGORY_LINK, link)
                    }
                }
    }
}
