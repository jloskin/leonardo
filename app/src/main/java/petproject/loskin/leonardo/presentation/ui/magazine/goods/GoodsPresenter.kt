package petproject.loskin.leonardo.presentation.ui.magazine.goods

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor
import javax.inject.Inject

@InjectViewState
class GoodsPresenter @Inject constructor(
        private val mainInteractor: MainInteractor
) : MvpPresenter<GoodsView>() {
    fun loadGoods(item: String) {
        mainInteractor.getGoods(item)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(viewState::loadGoodsCategories, Throwable::printStackTrace)
    }
}