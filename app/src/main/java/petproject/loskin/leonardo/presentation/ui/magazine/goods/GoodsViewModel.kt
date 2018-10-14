package petproject.loskin.leonardo.presentation.ui.magazine.goods

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor
import javax.inject.Inject

class GoodsViewModel @Inject constructor(
        private val mainInteractor: MainInteractor
) : ViewModel() {
    fun loadGoods(item: String) = mainInteractor.getGoods(item)
            .observeOn(AndroidSchedulers.mainThread())
}