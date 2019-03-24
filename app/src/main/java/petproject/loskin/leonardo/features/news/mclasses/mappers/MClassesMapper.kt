package petproject.loskin.leonardo.features.news.mclasses.mappers

import org.jsoup.Jsoup
import petproject.loskin.leonardo.features.news.competitions.models.CompetitionsBlock
import javax.inject.Inject

class MClassesMapper @Inject constructor() {
    fun string2News(page: String): List<CompetitionsBlock> = Jsoup.parse(page)
        .select("div.artlessonsitem").map {
            val title = it.select("div.title a")
            CompetitionsBlock(
                title.text(),
                title.attr("href"),
                "https://leonardo.ru${it.select("img").attr("src")}",
                it.select(".text").text(),
                it.select(".left").text().trim(),
                it.select("div.like-active").text()
            )
        }
}
