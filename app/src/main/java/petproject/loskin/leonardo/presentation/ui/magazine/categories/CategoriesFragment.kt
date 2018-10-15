package petproject.loskin.leonardo.presentation.ui.magazine.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.recycler_view.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.data.entity.magazine.CategoriesData
import petproject.loskin.leonardo.presentation.ui.main.MainActivity


class CategoriesFragment : Fragment() {
    private val viewModel: CategoriesViewModel by viewModel()

    private val adapter: CategoriesAdapter by lazy {
        CategoriesAdapter {
            this@CategoriesFragment.view
                    ?.let(Navigation::findNavController)
                    ?.navigate(
                            R.id.subCategoriesFragment,
                            Bundle().apply { putString(CATEGORY_LINK, it.categoryLink) },
                            MainActivity.options
                    )
        }
    }

    fun loadGoodsCategories(items: List<CategoriesData>) {
        adapter.update(items)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.recycler_view, container, false)

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