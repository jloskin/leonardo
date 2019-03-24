package petproject.loskin.leonardo.features.shop.categories.mappers

import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import petproject.loskin.leonardo.base.db.dao.profile.City
import petproject.loskin.leonardo.base.db.dao.shop.MenuL
import javax.inject.Inject

class CategoriesMapper @Inject constructor() {
    fun string2Menu(page: String): List<MenuL> = Jsoup.parse(page)
        .select(".cd-dropdown-content")
        .first()
        .children()
        .map(Element::children)
        .map {
            val first = it.first()
            val url = parseHref(first)
            listOf(MenuL(url, first.text())) +
                it.select(".block").map(Element::children).flatMap { subCategory ->
                    val url1 = parseHref(subCategory.first())
                    listOf(MenuL(url1, subCategory.first().text(), url)) +
                        subCategory.select("li").select("a").map { MenuL(parseHref(it), it.text(), url1) }
                }
        }
        .flatten()

    private fun parseHref(element: Element): String = element.attr("href").replace(Regex(".+(tree_.+)/"), "$1")

    fun string2Cities(page: String): List<City> = Jsoup.parse(page)
        .select("a.city_select")
        .map { City(it.attr("data-city"), it.text()) }
}
