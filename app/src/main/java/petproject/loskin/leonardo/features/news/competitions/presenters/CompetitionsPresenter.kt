package petproject.loskin.leonardo.features.news.competitions.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import petproject.loskin.leonardo.features.news.competitions.repositories.CompetitionsRepositories
import petproject.loskin.leonardo.features.news.competitions.ui.CompetitionsView
import petproject.loskin.leonardo.util.rx.applySchedulers
import javax.inject.Inject

@InjectViewState
class CompetitionsPresenter @Inject constructor(
    repositories: CompetitionsRepositories
) : MvpPresenter<CompetitionsView>() {
    init {
        repositories.getCompetitions()
            .applySchedulers()
            .subscribe(viewState::update, Throwable::printStackTrace)
    }
}