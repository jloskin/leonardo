package petproject.loskin.leonardo.data.mapper.magazine.categories

import org.jsoup.Jsoup
import petproject.loskin.leonardo.data.entity.magazine.categories.CategoriesData

class CategoriesMapper {
    fun string2categoriesData(page: String): List<CategoriesData> {
        val parse = Jsoup.parse(page)
        return parse.select("div.ishop-half-block").map {
            val title = it.select("div.name a")
            CategoriesData(
                    "https://leonardohobby.ru${it.select("img").attr("src")}",
                    title.text(),
                    "https://leonardohobby.ru${title.attr("href")}"
            )
        }
    }
}
