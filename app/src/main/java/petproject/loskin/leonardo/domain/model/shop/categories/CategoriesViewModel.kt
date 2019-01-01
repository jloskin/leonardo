package petproject.loskin.leonardo.domain.model.shop.categories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import petproject.loskin.leonardo.data.entity.shop.MenuL
import petproject.loskin.leonardo.domain.repositories.shop.categories.CategoriesRepository
import petproject.loskin.leonardo.util.rx.applySchedulers

class CategoriesViewModel(
  categoriesRepository: CategoriesRepository
) : ViewModel() {
  val categories = MutableLiveData<List<MenuL>>()

  init {
    categoriesRepository.initMenu().applySchedulers()
      .subscribe(categories::setValue, Throwable::printStackTrace)
  }
}