package petproject.loskin.leonardo.presentation.ui.magazine

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
import petproject.loskin.leonardo.domain.main.GoodsCategories
import petproject.loskin.leonardo.presentation.presenter.magazine.GoodsCategoriesPresenter
import javax.inject.Inject

class GoodsCategoriesFragment : MvpAppCompatFragment(), GoodsCategoriesView {

    @InjectPresenter
    @Inject
    lateinit var presenter: GoodsCategoriesPresenter

    init {
        GoodsComponentHandler.goodsComponent.inject(this)
        presenter.loadGoodsCategories()
    }

    @ProvidePresenter
    fun presenter() = presenter

    private val adapter: GoodsCategoriesAdapter by lazy {
        GoodsCategoriesAdapter {
            this@GoodsCategoriesFragment.view
                    ?.let(Navigation::findNavController)
                    ?.navigate(R.id.magazineCategoryFragment2, Bundle().apply { putString(CATEGORY_LINK, it.categoryLink) })
        }
    }

    override fun loadGoodsCategories(items: List<GoodsCategories>) {
        adapter.update(items)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.recycler_view, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(recyclerView) {
            layoutManager = GridLayoutManager(context, 3)
            adapter = this@GoodsCategoriesFragment.adapter
        }
    }

    companion object {
        const val CATEGORY_LINK = "CATEGORY_LINK"
    }
}