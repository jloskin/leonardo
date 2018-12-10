package petproject.loskin.leonardo.domain.model.shop.subcategories

import io.reactivex.Flowable
import petproject.loskin.leonardo.data.db.dao.magazine.categories.ShopDao
import petproject.loskin.leonardo.data.entity.shop.MenuL

class SubCategoriesRepository(
  private val shopDao: ShopDao
) {
  fun load(item: String): Flowable<List<MenuL>> = shopDao.menus(item)
}
