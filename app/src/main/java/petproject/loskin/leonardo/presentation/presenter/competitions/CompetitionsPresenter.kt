package petproject.loskin.leonardo.presentation.presenter.competitions

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor

class CompetitionsPresenter(
        mainInteractor: MainInteractor,
        application: Application
) : AndroidViewModel(application) {
    init {
        mainInteractor.getCompetitions()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, Throwable::printStackTrace)
    }
}