package petproject.loskin.leonardo.presentation.presenter.magazine

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor
import petproject.loskin.leonardo.presentation.ui.magazine.GoodsCategoriesView
import javax.inject.Inject

@InjectViewState
class GoodsCategoriesPresenter @Inject constructor(
        private val mainInteractor: MainInteractor
) : MvpPresenter<GoodsCategoriesView>() {
    fun loadGoodsCategories() {
        mainInteractor.loadGoodsCategories()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(viewState::loadGoodsCategories, Throwable::printStackTrace)
    }
}