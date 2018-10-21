package petproject.loskin.leonardo.repositories.magazine.categories

import io.reactivex.schedulers.Schedulers
import petproject.loskin.leonardo.data.db.dao.magazine.categories.CategoriesDao
import petproject.loskin.leonardo.data.network.RetrofitClientInstance
import petproject.loskin.leonardo.data.mapper.magazine.categories.CategoriesMapper
import petproject.loskin.leonardo.data.network.magazine.categories.CategoriesService

class CategoriesRepository(
        private val categoriesDao: CategoriesDao,
        private val categoriesMapper: CategoriesMapper
) {
    private val service = RetrofitClientInstance.retrofit.create(CategoriesService::class.java)

    fun categories() = service.loadGoodsCategories()
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .map(categoriesMapper::string2categoriesData)
            .doOnNext(categoriesDao::insertAll)
}
