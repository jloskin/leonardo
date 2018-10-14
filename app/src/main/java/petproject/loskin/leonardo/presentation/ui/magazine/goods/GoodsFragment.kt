package petproject.loskin.leonardo.presentation.ui.magazine.goods

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R
import petproject.loskin.leonardo.di.Injectable
import petproject.loskin.leonardo.presentation.ui.magazine.categories.CategoriesFragment
import petproject.loskin.leonardo.presentation.ui.main.MainActivity
import javax.inject.Inject

class GoodsFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: GoodsViewModel by lazy {
        ViewModelProviders.of(activity!!, viewModelFactory).get(GoodsViewModel::class.java)
    }

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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        arguments?.getString(CategoriesFragment.CATEGORY_LINK)?.let(viewModel::loadGoods)
                ?.subscribe(adapter::update, Throwable::printStackTrace)
        return inflater.inflate(R.layout.recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(recyclerView) {
            layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, 2)
            adapter = this@GoodsFragment.adapter
        }
    }

    companion object {
        const val CATEGORY_LINK = "CATEGORY_LINK"
    }
}