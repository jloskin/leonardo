package petproject.loskin.leonardo.presentation.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import petproject.loskin.leonardo.data.mapper.magazine.categories.City

class FilterCityViewModel(
        categoriesRepository: FilterCityRepository
) : ViewModel() {
    val cities = MutableLiveData<List<City>>()

    init {
        categoriesRepository.init()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(cities::setValue, Throwable::printStackTrace)
    }
}
