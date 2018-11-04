package petproject.loskin.leonardo.domain.magazine.categories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.data.entity.magazine.MenuL
import petproject.loskin.leonardo.repositories.magazine.categories.CategoriesRepository


class CategoriesViewModel(
        categoriesRepository: CategoriesRepository
) : ViewModel() {
    val categories = MutableLiveData<List<MenuL>>()

    init {
        categoriesRepository.initMenu()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(categories::setValue, Throwable::printStackTrace)
    }
}