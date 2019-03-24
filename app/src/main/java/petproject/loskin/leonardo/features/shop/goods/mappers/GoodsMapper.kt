package petproject.loskin.leonardo.features.shop.goods.mappers

import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import petproject.loskin.leonardo.features.shop.goods.features.filters.models.Filter
import petproject.loskin.leonardo.features.shop.goods.features.filters.models.FilterEntity
import petproject.loskin.leonardo.features.shop.goods.models.GoodsData
import petproject.loskin.leonardo.features.shop.goods.models.Price
import javax.inject.Inject

class GoodsMapper @Inject constructor() {
    fun page2Goods(page: String): List<GoodsData> = Jsoup.parse(page)
        .select(".gooditem").map {
            val img = it.select(".image").select("a").select("img").attr("newsrc")
            val title = it.select(".title").select("a").first()
            val urlItem = title.attr("href").replace(Regex(".+(group_.+)/"), "$1")
            val itemName = title.text()
            val price = it.select(".hp_caritemprice").first().childNodes()
            val prices: Pair<Price?, Price> = if (price.size == 4) {
                val ruble = price.first().toString()
                val kopeek = (price.component2() as Element).text()
                val currency = price.component4().toString().trim()
                Pair(null, Price(ruble, kopeek, currency))
            } else {
                val ruble = price.component2().toString()
                val kopeek = (price.component3() as Element).text()
                val currency = price.component5().toString().trim()
                val oldRuble = price.first().childNodes().first().toString()
                val oldKopeek = (price.first().childNodes().component2() as Element).text()
                Pair(
                    Price(oldRuble, oldKopeek, currency),
                    Price(ruble, kopeek, currency)
                )
            }
            GoodsData(
                img,
                itemName,
                urlItem
            )
        }

    fun page2Filter(page: String): List<Filter> = Jsoup.parse(page)
        .select("div.filterscontainer")
        .select(".sidebar-filter-block")
        .map {
            Filter(
                it.select(".sbmenublocktitle div").text(),
                it.select(".sbcatmenu label").map { FilterEntity(it.attr("for"), it.text()) }
            )
        }
}
