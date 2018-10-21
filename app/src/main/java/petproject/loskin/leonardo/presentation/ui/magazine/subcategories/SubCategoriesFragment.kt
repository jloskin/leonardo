package petproject.loskin.leonardo.presentation.ui.magazine.subcategories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R

class SubCategoriesFragment : Fragment() {
    val presenter: SubCategoriesViewModel by viewModel()

    private val adapter: SubCategoriesAdapter by lazy {
        SubCategoriesAdapter {
            this@SubCategoriesFragment.view
                    ?.findNavController()
                    ?.navigate(SubCategoriesFragmentDirections.subcategories2goods(it.itemUrl))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadSubCategories(SubCategoriesFragmentArgs.fromBundle(arguments).subCategoriesLink)
                .subscribe(adapter::update, Throwable::printStackTrace)
        with(recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = this@SubCategoriesFragment.adapter
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.recycler_view, container, false)
}
