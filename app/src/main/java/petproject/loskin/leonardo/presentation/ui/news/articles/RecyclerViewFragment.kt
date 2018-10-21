package petproject.loskin.leonardo.presentation.ui.news.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.recycler_view.*
import petproject.loskin.leonardo.R

abstract class RecyclerViewFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(R.layout.recycler_view, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(recyclerView) {
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
            adapter = this@RecyclerViewFragment.adapter
        }
    }

    abstract val adapter: androidx.recyclerview.widget.RecyclerView.Adapter<*>?
}
