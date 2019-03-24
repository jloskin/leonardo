package petproject.loskin.leonardo.features.news.mclasses.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import petproject.loskin.leonardo.features.news.mclasses.repositories.MClassesRepository
import petproject.loskin.leonardo.features.news.mclasses.ui.MClassesView
import petproject.loskin.leonardo.util.rx.applySchedulers
import javax.inject.Inject

@InjectViewState
class MClassesPresenter @Inject constructor(
    repository: MClassesRepository
) : MvpPresenter<MClassesView>() {
    init {
        repository.getMClasses()
            .applySchedulers()
            .subscribe(viewState::update, Throwable::printStackTrace)
    }
}