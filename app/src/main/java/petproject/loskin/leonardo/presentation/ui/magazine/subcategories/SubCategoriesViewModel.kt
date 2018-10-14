package petproject.loskin.leonardo.presentation.ui.magazine.subcategories

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.domain.main.MainInteractor
import javax.inject.Inject

class SubCategoriesViewModel @Inject constructor(
        private val mainInteractor: MainInteractor
) : ViewModel() {
    fun loadSubCategories(item: String) = mainInteractor.load(item)
            .observeOn(AndroidSchedulers.mainThread())
}