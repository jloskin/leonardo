package petproject.loskin.leonardo.presentation.presenter.news.competitions

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor

class CompetitionsPresenter(
        val mainInteractor: MainInteractor,
        application: Application
) : AndroidViewModel(application) {
    fun competitons() = mainInteractor.getCompetitions()
            .observeOn(AndroidSchedulers.mainThread())
}