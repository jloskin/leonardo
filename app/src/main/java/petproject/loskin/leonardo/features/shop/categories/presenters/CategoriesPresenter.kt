package petproject.loskin.leonardo.features.shop.categories.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import petproject.loskin.leonardo.features.shop.categories.repositories.CategoriesRepository
import petproject.loskin.leonardo.features.shop.categories.ui.CategoriesView
import petproject.loskin.leonardo.util.rx.applySchedulers
import javax.inject.Inject

@InjectViewState
class CategoriesPresenter @Inject constructor(
    categoriesRepository: CategoriesRepository
) : MvpPresenter<CategoriesView>() {

    init {
        categoriesRepository.initMenu()
            .applySchedulers()
            .subscribe(viewState::setValue, Throwable::printStackTrace)
    }
}