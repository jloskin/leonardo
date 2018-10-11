package petproject.loskin.leonardo.presentation.ui.magazine.subcategories

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.domain.main.SubCategoriesData
import petproject.loskin.leonardo.presentation.ui.magazine.categories.CategoriesFragment
import petproject.loskin.leonardo.presentation.ui.magazine.MagazineComponentHandler
import petproject.loskin.leonardo.presentation.ui.main.MainActivity
import javax.inject.Inject

class SubCategoriesFragment : MvpAppCompatFragment(), SubCategoriesView {
    @InjectPresenter
    @Inject
    lateinit var presenter: SubCategoriesPresenter

    init {
        MagazineComponentHandler.MAGAZINE_COMPONENT.inject(this)
    }

    @ProvidePresenter
    fun presenter() = presenter

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

    override fun loadPage(items: List<SubCategoriesData>) {
        adapter.update(items)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = this@SubCategoriesFragment.adapter
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        arguments?.getString(CategoriesFragment.CATEGORY_LINK)?.let(presenter::loadSubCategories)
        return inflater.inflate(R.layout.recycler_view, container, false)
    }
}
