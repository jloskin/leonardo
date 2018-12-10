package petproject.loskin.leonardo.domain.model.shop.goods

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.data.entity.shop.MenuL
import petproject.loskin.leonardo.data.entity.shop.goods.GoodsData

class GoodsViewModel(
  private val goodsRepository: GoodsRepository
) : ViewModel() {
  val goods = MutableLiveData<List<GoodsData>>()
  val chips = MutableLiveData<List<MenuL>>()
  val filters = MutableLiveData<List<Filter>>()

  fun loadGoods(item: String) {
    goodsRepository.chips(item)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(chips::setValue, Throwable::printStackTrace)

    goodsRepository.getGoods(item)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe({
        goods.value = it
        filters.value = goodsRepository.filters
      }, Throwable::printStackTrace)
  }
}