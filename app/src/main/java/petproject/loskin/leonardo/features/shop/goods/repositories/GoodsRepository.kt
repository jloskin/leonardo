package petproject.loskin.leonardo.features.shop.goods.repositories

import io.reactivex.Flowable
import io.reactivex.Observable
import petproject.loskin.leonardo.base.db.dao.shop.MenuL
import petproject.loskin.leonardo.base.db.dao.shop.ShopDao
import petproject.loskin.leonardo.features.shop.goods.features.filters.models.Filter
import petproject.loskin.leonardo.features.shop.goods.mappers.GoodsMapper
import petproject.loskin.leonardo.features.shop.goods.models.GoodsData
import petproject.loskin.leonardo.features.shop.goods.services.GoodsService
import javax.inject.Inject

class GoodsRepository @Inject constructor(
    private val shopDao: ShopDao,
    private val goodsMapper: GoodsMapper,
    private val service: GoodsService
) {
    val filters: MutableList<Filter> = mutableListOf()

    fun chips(item: String): Flowable<List<MenuL>> = shopDao.menus(item)

    fun getGoods(item: String, page: String = ""): Observable<Pair<List<GoodsData>, List<Filter>>> = service.goods(item)
        .map { Pair(goodsMapper.string2Goods(it), goodsMapper.string2Filter(it)) }
}
