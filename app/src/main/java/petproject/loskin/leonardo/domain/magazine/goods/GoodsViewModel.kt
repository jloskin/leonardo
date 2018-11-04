package petproject.loskin.leonardo.domain.magazine.goods

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.data.entity.magazine.MenuL
import petproject.loskin.leonardo.data.entity.magazine.goods.GoodsData

class GoodsViewModel(
        private val goodsRepository: GoodsRepository
) : ViewModel() {
    val goods = MutableLiveData<List<GoodsData>>()
    val chips = MutableLiveData<List<MenuL>>()

    fun loadGoods(item: String) {
        goodsRepository.chips(item)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(chips::setValue, Throwable::printStackTrace)

        goodsRepository.getGoods(item)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(goods::setValue, Throwable::printStackTrace)
    }
}