package petproject.loskin.leonardo.domain.magazine.subcategories

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor

class SubCategoriesViewModel(
        private val mainInteractor: MainInteractor
) : ViewModel() {
    fun loadSubCategories(item: String) = mainInteractor.load(item)
            .observeOn(AndroidSchedulers.mainThread())
}