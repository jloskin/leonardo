package petproject.loskin.leonardo.domain.magazine.categories

import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.repositories.magazine.categories.CategoriesRepository

class CategoriesViewModel(
        private val categoriesRepository: CategoriesRepository
) : ViewModel() {
    fun categories() = categoriesRepository.categories()
            .observeOn(AndroidSchedulers.mainThread())
}