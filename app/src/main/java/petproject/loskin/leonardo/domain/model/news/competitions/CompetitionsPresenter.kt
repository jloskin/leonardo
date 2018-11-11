package petproject.loskin.leonardo.domain.model.news.competitions

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.model.main.MainInteractor

class CompetitionsPresenter(
        val mainInteractor: MainInteractor,
        application: Application
) : AndroidViewModel(application) {
    fun competitons() = mainInteractor.getCompetitions()
            .observeOn(AndroidSchedulers.mainThread())
}