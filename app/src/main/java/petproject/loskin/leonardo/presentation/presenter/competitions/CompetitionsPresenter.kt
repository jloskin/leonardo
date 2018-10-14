package petproject.loskin.leonardo.presentation.presenter.competitions

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor
import petproject.loskin.leonardo.presentation.view.competitions.CompetitionsView
import javax.inject.Inject

class CompetitionsPresenter @Inject constructor(
        mainInteractor: MainInteractor,
        application: Application
) : AndroidViewModel(application) {
    init {
        mainInteractor.getCompetitions()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, Throwable::printStackTrace)
    }
}