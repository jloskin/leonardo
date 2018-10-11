package petproject.loskin.leonardo.presentation.ui.magazine.categories

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor
import javax.inject.Inject

@InjectViewState
class CategoriesPresenter @Inject constructor(
        private val mainInteractor: MainInteractor
) : MvpPresenter<CategoriesView>() {
    fun loadGoodsCategories() {
        mainInteractor.loadGoodsCategories()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(viewState::loadGoodsCategories, Throwable::printStackTrace)
    }
}