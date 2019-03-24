package petproject.loskin.leonardo.features.profile.cities.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import petproject.loskin.leonardo.features.profile.cities.repositories.CitiesRepository
import petproject.loskin.leonardo.features.profile.cities.ui.CitiesView
import petproject.loskin.leonardo.util.rx.applySchedulers
import javax.inject.Inject

@InjectViewState
class CitiesPresenter @Inject constructor(
    repository: CitiesRepository
) : MvpPresenter<CitiesView>() {
    init {
        repository.cities()
            .applySchedulers()
            .subscribe(viewState::update, Throwable::printStackTrace)
    }
}
