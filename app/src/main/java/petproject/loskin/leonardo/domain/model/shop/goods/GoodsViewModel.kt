package petproject.loskin.leonardo.domain.model.shop.goods

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import petproject.loskin.leonardo.data.entity.shop.MenuL
import petproject.loskin.leonardo.data.entity.shop.goods.Filter
import petproject.loskin.leonardo.data.entity.shop.goods.GoodsData
import petproject.loskin.leonardo.domain.repositories.shop.GoodsRepository
import petproject.loskin.leonardo.util.rx.applySchedulers

class GoodsViewModel(
  private val goodsRepository: GoodsRepository
) : ViewModel() {
  val goods = MutableLiveData<List<GoodsData>>()
  val chips = MutableLiveData<List<MenuL>>()
  val filters = MutableLiveData<List<Filter>>()

  fun loadGoods(item: String) {
    goodsRepository.chips(item).applySchedulers()
      .subscribe(chips::setValue, Throwable::printStackTrace)

    goodsRepository.getGoods(item).applySchedulers()
      .subscribe({
        goods.value = it.first
        filters.value = it.second
      }, Throwable::printStackTrace)
  }
}