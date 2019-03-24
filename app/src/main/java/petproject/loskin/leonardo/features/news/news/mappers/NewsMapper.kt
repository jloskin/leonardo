package petproject.loskin.leonardo.features.news.news.mappers

import org.jsoup.Jsoup
import petproject.loskin.leonardo.features.news.base.models.NewsBlock
import javax.inject.Inject

class NewsMapper @Inject constructor() {
    fun string2News(page: String): List<NewsBlock> = Jsoup.parse(page)
        .select("div.item").select(".clearfix.inner").map {
            val title = it.select("div.title a")
            NewsBlock(
                "https://leonardo.ru${it.select("div.left a img").attr("src")}",
                title.text(),
                title.attr("href"),
                it.select("div.text").text(),
                it.select("div span.news-date").text(),
                it.select("div.like-active").text()
            )
        }
}
