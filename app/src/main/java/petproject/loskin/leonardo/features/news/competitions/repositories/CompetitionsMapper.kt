package petproject.loskin.leonardo.features.news.competitions.repositories

import org.jsoup.Jsoup
import petproject.loskin.leonardo.features.news.competitions.models.CompetitionsBlock
import javax.inject.Inject

class CompetitionsMapper @Inject constructor() {
  fun page2Competitions(page: String) = Jsoup.parse(page)
    .select("div.competitionitem").map {
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
