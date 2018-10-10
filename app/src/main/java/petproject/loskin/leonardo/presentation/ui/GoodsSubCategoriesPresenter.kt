package petproject.loskin.leonardo.presentation.ui

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor
import javax.inject.Inject

@InjectViewState
class GoodsSubCategoriesPresenter @Inject constructor(
        private val mainInteractor: MainInteractor
) : MvpPresenter<GoodsSubCategoriesView>() {
    fun goodsPage(item: String) {
        mainInteractor.getGoods(item)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, Throwable::printStackTrace)
    }

    fun listPage(item: String) {
        mainInteractor.load(item)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(viewState::loadPage, Throwable::printStackTrace)
    }
}