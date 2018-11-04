package petproject.loskin.leonardo.domain.magazine.goods

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import petproject.loskin.leonardo.data.db.dao.magazine.categories.MagazineDao
import petproject.loskin.leonardo.data.entity.magazine.MenuL
import petproject.loskin.leonardo.data.entity.magazine.goods.GoodsData
import petproject.loskin.leonardo.data.network.RetrofitClientInstance

class GoodsRepository(
        private val magazineDao: MagazineDao,
        private val goodsMapper: GoodsMapper
) {
    private val service = RetrofitClientInstance.retrofit.create(GoodsService::class.java)

    fun chips(item: String): Flowable<List<MenuL>> = magazineDao.getMenus(item)

    fun getGoods(url: String): Observable<List<GoodsData>> = service.getUrl(url)
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .map(goodsMapper::string2Goods)
}
