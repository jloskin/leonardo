package petproject.loskin.leonardo.presentation.ui.magazine.goods

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
import petproject.loskin.leonardo.data.entity.GoodsData
import petproject.loskin.leonardo.presentation.ui.magazine.MagazineComponentHandler
import petproject.loskin.leonardo.presentation.ui.magazine.categories.CategoriesFragment
import petproject.loskin.leonardo.presentation.ui.main.MainActivity
import javax.inject.Inject

class GoodsFragment : MvpAppCompatFragment(), GoodsView {

    @InjectPresenter
    @Inject
    lateinit var presenter: GoodsPresenter

    init {
        MagazineComponentHandler.MAGAZINE_COMPONENT.inject(this)
    }

    @ProvidePresenter
    fun presenter() = presenter

    private val adapter: GoodsAdapter by lazy {
        GoodsAdapter {
            this@GoodsFragment.view
                    ?.let(Navigation::findNavController)
                    ?.navigate(
                            R.id.subCategoriesFragment,
                            Bundle().apply { putString(CATEGORY_LINK, it.urlItem) },
                            MainActivity.options
                    )
        }
    }

    override fun loadGoodsCategories(items: List<GoodsData>) {
        adapter.update(items)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        arguments?.getString(CategoriesFragment.CATEGORY_LINK)?.let(presenter::loadGoods)
        return inflater.inflate(R.layout.recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(recyclerView) {
            layoutManager = GridLayoutManager(context, 2)
            adapter = this@GoodsFragment.adapter
        }
    }

    companion object {
        const val CATEGORY_LINK = "CATEGORY_LINK"
    }
}