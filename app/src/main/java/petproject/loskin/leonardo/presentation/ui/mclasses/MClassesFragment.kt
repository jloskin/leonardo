package petproject.loskin.leonardo.presentation.ui.mclasses

import androidx.fragment.app.Fragment
import petproject.loskin.leonardo.data.entity.competitions.CompetitionsBlock
import petproject.loskin.leonardo.di.Injectable
import petproject.loskin.leonardo.presentation.presenter.mclasses.MClassesPresenter
import javax.inject.Inject


class MClassesFragment : Fragment(), Injectable {
    @Inject
    lateinit var newsPresenter: MClassesPresenter

    fun updateMClasses(item: List<CompetitionsBlock>) {
        adapter.update(item)
    }

    val adapter: MClassesAdapter by lazy { MClassesAdapter() }
}
