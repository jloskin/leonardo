package petproject.loskin.leonardo.domain.model.shop.subcategories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import petproject.loskin.leonardo.data.entity.shop.MenuL
import petproject.loskin.leonardo.domain.repositories.shop.subcategories.SubCategoriesRepository
import petproject.loskin.leonardo.util.rx.applySchedulers

class SubCategoriesViewModel(
  private val subCategoriesRepository: SubCategoriesRepository
) : ViewModel() {
  val subCategories = MutableLiveData<List<MenuL>>()

  fun loadSubCategories(item: String) {
    subCategoriesRepository.load(item).applySchedulers()
      .subscribe(subCategories::setValue, Throwable::printStackTrace)
  }
}