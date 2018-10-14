package petproject.loskin.leonardo.presentation.ui.magazine.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.data.entity.magazine.CategoriesData
import petproject.loskin.leonardo.di.Injectable
import petproject.loskin.leonardo.presentation.ui.main.MainActivity
import javax.inject.Inject


class CategoriesFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: CategoriesViewModel by lazy {
        ViewModelProviders.of(activity!!, viewModelFactory).get(CategoriesViewModel::class.java)
    }

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

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