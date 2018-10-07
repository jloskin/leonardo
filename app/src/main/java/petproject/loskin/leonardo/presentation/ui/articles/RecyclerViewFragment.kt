package petproject.loskin.leonardo.presentation.ui.articles

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R

abstract class RecyclerViewFragment : MvpAppCompatFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(R.layout.recycler_view, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = this@RecyclerViewFragment.adapter
        }
    }

    abstract val adapter: RecyclerView.Adapter<*>?
}
