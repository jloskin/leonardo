package petproject.loskin.leonardo.features.profile.cities.repositories

import io.reactivex.Flowable
import petproject.loskin.leonardo.base.db.dao.profile.City
import petproject.loskin.leonardo.base.db.dao.shop.ShopDao
import javax.inject.Inject

class CitiesRepository @Inject constructor(
    private val shopDao: ShopDao
) {
    fun init(): Flowable<List<City>> = shopDao.getCities()
}
