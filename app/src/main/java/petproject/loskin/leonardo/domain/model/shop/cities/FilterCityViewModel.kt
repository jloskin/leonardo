package petproject.loskin.leonardo.domain.model.shop.cities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import petproject.loskin.leonardo.data.entity.shop.City
import petproject.loskin.leonardo.domain.repositories.shop.cities.CitiesRepository
import petproject.loskin.leonardo.util.rx.applySchedulers

class FilterCityViewModel(
  categoriesRepository: CitiesRepository
) : ViewModel() {
  val cities = MutableLiveData<List<City>>()

  init {
    categoriesRepository.init()
      .applySchedulers()
      .subscribe(cities::setValue, Throwable::printStackTrace)
  }
}
