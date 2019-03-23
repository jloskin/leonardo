package petproject.loskin.leonardo.features.shop.subcategories.repositories

import io.reactivex.Flowable
import petproject.loskin.leonardo.base.db.dao.shop.ShopDao
import petproject.loskin.leonardo.base.db.dao.shop.MenuL
import javax.inject.Inject

class SubCategoriesRepository @Inject constructor(
  private val shopDao: ShopDao
) {
  fun load(item: String): Flowable<List<MenuL>> = shopDao.menus(item)
}
