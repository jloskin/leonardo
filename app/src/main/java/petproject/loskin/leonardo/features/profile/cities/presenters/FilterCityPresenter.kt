package petproject.loskin.leonardo.features.profile.cities.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import petproject.loskin.leonardo.features.profile.cities.repositories.CitiesRepository
import petproject.loskin.leonardo.features.profile.cities.ui.FilterCityView
import petproject.loskin.leonardo.util.rx.applySchedulers
import javax.inject.Inject

@InjectViewState
class FilterCityPresenter @Inject constructor(
    categoriesRepository: CitiesRepository
) : MvpPresenter<FilterCityView>() {
    init {
        categoriesRepository.init()
            .applySchedulers()
            .subscribe(viewState::update, Throwable::printStackTrace)
    }
}
