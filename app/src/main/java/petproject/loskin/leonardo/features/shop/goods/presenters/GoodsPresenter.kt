package petproject.loskin.leonardo.features.shop.goods.presenters

import androidx.lifecycle.MutableLiveData
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import petproject.loskin.leonardo.base.db.dao.shop.MenuL
import petproject.loskin.leonardo.features.shop.goods.features.filters.models.Filter
import petproject.loskin.leonardo.features.shop.goods.models.GoodsData
import petproject.loskin.leonardo.features.shop.goods.repositories.GoodsRepository
import petproject.loskin.leonardo.features.shop.goods.ui.GoodsView
import petproject.loskin.leonardo.util.rx.applySchedulers
import javax.inject.Inject

@InjectViewState
class GoodsPresenter @Inject constructor(
  private val repository: GoodsRepository
) : MvpPresenter<GoodsView>() {
  val goods = MutableLiveData<List<GoodsData>>()
  val chips = MutableLiveData<List<MenuL>>()
  val filters = MutableLiveData<List<Filter>>()

  fun loadGoods(item: String) {
    repository.chips(item).applySchedulers()
      .subscribe(chips::setValue, Throwable::printStackTrace)

    repository.getGoods(item).applySchedulers()
      .subscribe({
        goods.value = it.first
        filters.value = it.second
      }, Throwable::printStackTrace)
  }
}