package petproject.loskin.leonardo.presentation.ui

import io.reactivex.Flowable
import petproject.loskin.leonardo.data.db.dao.magazine.categories.MagazineDao
import petproject.loskin.leonardo.data.mapper.magazine.categories.City

class FilterCityRepository(
        private val magazineDao: MagazineDao
) {
    fun init(): Flowable<List<City>> = magazineDao.getCities()
}
