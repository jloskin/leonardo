package petproject.loskin.leonardo.presentation.ui.magazine.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.magazine.categories.CategoriesViewModel


class CategoriesFragment : Fragment() {
    private val viewModel: CategoriesViewModel by viewModel()

    private val adapter: CategoriesAdapter by lazy {
        CategoriesAdapter {
            this@CategoriesFragment.view
                    ?.findNavController()
                    ?.navigate(CategoriesFragmentDirections.categories2subcategories(it.categoryLink))
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.recycler_view, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.categories().subscribe(adapter::update, Throwable::printStackTrace)
        with(recyclerView) {
            layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, 3)
            adapter = this@CategoriesFragment.adapter
        }
    }

    companion object {
        const val CATEGORY_LINK = "CATEGORY_LINK"
    }
}