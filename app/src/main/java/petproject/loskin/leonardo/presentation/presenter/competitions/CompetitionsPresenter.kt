package petproject.loskin.leonardo.presentation.presenter.competitions

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor
import petproject.loskin.leonardo.presentation.view.competitions.CompetitionsView
import javax.inject.Inject

@InjectViewState
class CompetitionsPresenter @Inject constructor(
        mainInteractor: MainInteractor
) : MvpPresenter<CompetitionsView>() {
    init {
        mainInteractor.getCompetitions()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(viewState::updateCompetitions, Throwable::printStackTrace)
    }
}