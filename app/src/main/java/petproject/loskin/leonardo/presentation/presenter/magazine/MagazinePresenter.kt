package petproject.loskin.leonardo.presentation.presenter.magazine

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.ItemMagazine
import petproject.loskin.leonardo.domain.main.MagazineItem
import petproject.loskin.leonardo.domain.main.MainInteractor
import petproject.loskin.leonardo.presentation.view.magazine.MagazineView
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MagazinePresenter @Inject constructor(
        private val mainInteractor: MainInteractor,
        private val router: Router
) : MvpPresenter<MagazineView>() {

    fun loadGoods(item: ItemMagazine) {
        mainInteractor.getGoods(item.itemUrl)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(viewState::loadGoods, Throwable::printStackTrace)
    }

    fun load(item: MagazineItem) {
        mainInteractor.load(item)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(viewState::nextPage, Throwable::printStackTrace)
    }

    fun backHandler() {
        mainInteractor.getMagazine()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(viewState::updateMagazine, Throwable::printStackTrace)
    }

    init {
        backHandler()
    }
}