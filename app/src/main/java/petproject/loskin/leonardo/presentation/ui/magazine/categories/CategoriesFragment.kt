package petproject.loskin.leonardo.presentation.ui.magazine.categories

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.main.CategoriesData
import petproject.loskin.leonardo.presentation.ui.magazine.MagazineComponentHandler
import petproject.loskin.leonardo.presentation.ui.main.MainActivity
import javax.inject.Inject

class CategoriesFragment : MvpAppCompatFragment(), CategoriesView {

    @InjectPresenter
    @Inject
    lateinit var presenter: CategoriesPresenter

    init {
        MagazineComponentHandler.MAGAZINE_COMPONENT.inject(this)
        presenter.loadGoodsCategories()
    }

    @ProvidePresenter
    fun presenter() = presenter

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

    override fun loadGoodsCategories(items: List<CategoriesData>) {
        adapter.update(items)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.recycler_view, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(recyclerView) {
            layoutManager = GridLayoutManager(context, 3)
            adapter = this@CategoriesFragment.adapter
        }
    }

    companion object {
        const val CATEGORY_LINK = "CATEGORY_LINK"
    }
}