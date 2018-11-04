package petproject.loskin.leonardo.data.mapper.magazine.categories

import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import petproject.loskin.leonardo.data.entity.magazine.MenuL

class MagazineMapper {
    fun string2Menu(page: String): List<MenuL> {
        val parse = Jsoup.parse(page)
        return parse.select(".cd-dropdown-content").first().children()
                .map { it.children() }
                .map {
                    val url = getLink(it.first())
                    listOf(MenuL(
                            url,
                            it.first().text()
                    )) + it.select(".block").map(Element::children).flatMap { subCategory ->
                        val url1 = getLink(subCategory.first())
                        listOf(MenuL(
                                url1,
                                subCategory.first().text(),
                                parentId = url
                        )) + subCategory.select("li").select("a").map { MenuL(getLink(it), it.text(), parentId = url1) }
                    }
                }
                .flatten()
    }

    private fun getLink(element: Element): String = element.attr("href").replace(Regex(".+(tree_.+)/"), "$1")
}
