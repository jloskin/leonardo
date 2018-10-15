package petproject.loskin.leonardo.presentation.ui.magazine.subcategories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.presentation.ui.magazine.categories.CategoriesFragment
import petproject.loskin.leonardo.presentation.ui.main.MainActivity

class SubCategoriesFragment : Fragment() {
    val presenter: SubCategoriesViewModel by viewModel()

    private val adapter: SubCategoriesAdapter by lazy {
        SubCategoriesAdapter {
            this@SubCategoriesFragment.view
                    ?.let(Navigation::findNavController)
                    ?.navigate(
                            R.id.goodsFragment,
                            Bundle().apply { putString(CategoriesFragment.CATEGORY_LINK, it.itemUrl) },
                            MainActivity.options
                    )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(CategoriesFragment.CATEGORY_LINK)?.let(presenter::loadSubCategories)
                ?.subscribe(adapter::update, Throwable::printStackTrace)
        with(recyclerView) {
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
            adapter = this@SubCategoriesFragment.adapter
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.recycler_view, container, false)
}
