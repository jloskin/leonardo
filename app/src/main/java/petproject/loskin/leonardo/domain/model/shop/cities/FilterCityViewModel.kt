package petproject.loskin.leonardo.domain.model.shop.cities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.data.mapper.shop.categories.City
import petproject.loskin.leonardo.domain.repositories.shop.cities.CitiesRepository

class FilterCityViewModel(
        categoriesRepository: CitiesRepository
) : ViewModel() {
    val cities = MutableLiveData<List<City>>()

    init {
        categoriesRepository.init()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(cities::setValue, Throwable::printStackTrace)
    }
}
