package petproject.loskin.leonardo.domain.repositories.shop.cities

import io.reactivex.Flowable
import petproject.loskin.leonardo.data.db.dao.magazine.categories.ShopDao
import petproject.loskin.leonardo.data.entity.shop.City

class CitiesRepository(
  private val shopDao: ShopDao
) {
  fun init(): Flowable<List<City>> = shopDao.getCities()
}
