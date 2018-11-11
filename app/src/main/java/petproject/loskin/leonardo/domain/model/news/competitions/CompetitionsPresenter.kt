package petproject.loskin.leonardo.domain.model.news.competitions

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.model.main.MainInteractor

class CompetitionsPresenter(
        private val mainInteractor: MainInteractor
) : ViewModel() {
    fun competitons() = mainInteractor.getCompetitions()
            .observeOn(AndroidSchedulers.mainThread())
}