package petproject.loskin.leonardo.repositories.magazine.categories

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import petproject.loskin.leonardo.data.db.dao.magazine.categories.MagazineDao
import petproject.loskin.leonardo.data.entity.magazine.MenuL
import petproject.loskin.leonardo.data.mapper.magazine.categories.MagazineMapper
import petproject.loskin.leonardo.data.network.RetrofitClientInstance
import petproject.loskin.leonardo.data.network.magazine.categories.CategoriesService

class CategoriesRepository(
        private val magazineDao: MagazineDao,
        private val magazineMapper: MagazineMapper
) {
    private val service = RetrofitClientInstance.retrofit.create(CategoriesService::class.java)

    fun initMenu(): Flowable<List<MenuL>> = magazineDao.getMenus()
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .flatMap {
                if (it.isEmpty())
                    service.initMenu()
                            .map(magazineMapper::string2Menu)
                            .doOnNext(magazineDao::insertMenus)
                            .flatMap { magazineDao.getMenus() }
                else
                    Flowable.just(it)
            }
}