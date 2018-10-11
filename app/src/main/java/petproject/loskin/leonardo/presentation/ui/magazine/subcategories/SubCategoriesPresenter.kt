package petproject.loskin.leonardo.presentation.ui.magazine.subcategories

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor
import javax.inject.Inject

@InjectViewState
class SubCategoriesPresenter @Inject constructor(
        private val mainInteractor: MainInteractor
) : MvpPresenter<SubCategoriesView>() {
    fun loadSubCategories(item: String) {
        mainInteractor.load(item)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(viewState::loadPage, Throwable::printStackTrace)
    }
}