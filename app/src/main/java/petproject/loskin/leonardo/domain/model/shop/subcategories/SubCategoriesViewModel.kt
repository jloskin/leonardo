package petproject.loskin.leonardo.domain.model.shop.subcategories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.data.entity.shop.MenuL

class SubCategoriesViewModel(
  private val subCategoriesRepository: SubCategoriesRepository
) : ViewModel() {
  val subCategories = MutableLiveData<List<MenuL>>()

  fun loadSubCategories(item: String) {
    subCategoriesRepository.load(item)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(subCategories::setValue, Throwable::printStackTrace)
  }
}