package petproject.loskin.leonardo.presentation.ui.magazine.categories

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers

class CategoriesViewModel(
        private val categoriesRepository: CategoriesRepository
) : ViewModel() {
    fun categories() = categoriesRepository.categories()
            .observeOn(AndroidSchedulers.mainThread())
}