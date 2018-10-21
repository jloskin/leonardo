package petproject.loskin.leonardo.domain.magazine.goods

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor

class GoodsViewModel(
        private val mainInteractor: MainInteractor
) : ViewModel() {
    fun loadGoods(item: String) = mainInteractor.getGoods(item)
            .observeOn(AndroidSchedulers.mainThread())
}