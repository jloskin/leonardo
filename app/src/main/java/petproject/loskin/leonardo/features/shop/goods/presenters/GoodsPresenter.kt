package petproject.loskin.leonardo.features.shop.goods.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import petproject.loskin.leonardo.features.shop.goods.repositories.GoodsRepository
import petproject.loskin.leonardo.features.shop.goods.ui.GoodsView
import petproject.loskin.leonardo.util.rx.applySchedulers
import javax.inject.Inject

@InjectViewState
class GoodsPresenter @Inject constructor(
    item: String,
    repository: GoodsRepository
) : MvpPresenter<GoodsView>() {
    init {
        repository.chips(item).applySchedulers()
            .subscribe(viewState::updateMenu, Throwable::printStackTrace)

        repository.getGoods(item).applySchedulers()
            .subscribe({ (goods, filters) ->
                viewState.updateGoods(goods)
                if (filters.isNotEmpty())
                    viewState.updateFilters(filters)
            }, Throwable::printStackTrace)
    }
}