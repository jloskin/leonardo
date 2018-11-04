package petproject.loskin.leonardo.domain.magazine.subcategories

import io.reactivex.Flowable
import petproject.loskin.leonardo.data.db.dao.magazine.categories.MagazineDao
import petproject.loskin.leonardo.data.entity.magazine.MenuL

class SubCategoriesRepository(
        private val magazineDao: MagazineDao
) {
    fun load(item: String): Flowable<List<MenuL>> = magazineDao.getMenus(item)
}
