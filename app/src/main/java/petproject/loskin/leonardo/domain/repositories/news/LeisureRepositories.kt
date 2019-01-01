package petproject.loskin.leonardo.domain.repositories.news

import io.reactivex.Observable
import org.jsoup.Jsoup
import petproject.loskin.leonardo.data.entity.news.NewsBlock
import petproject.loskin.leonardo.data.entity.news.competitions.CompetitionsBlock
import petproject.loskin.leonardo.data.network.services.news.NewsService

class LeisureRepositories(
  private val service: NewsService
) {
  fun getNews(): Observable<List<NewsBlock>> = service.news()
    .map(Jsoup::parse)
    .map {
      it.select("div.item").select(".clearfix.inner").map {
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

  fun getCompetitions(): Observable<List<CompetitionsBlock>> = service.competitions()
    .map(Jsoup::parse)
    .map {
      it.select("div.competitionitem").map {
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

  fun getMClasses(): Observable<List<CompetitionsBlock>> = service.mClasses()
    .map(Jsoup::parse)
    .map {
      it.select("div.artlessonsitem").map {
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

  fun getArticles(): Observable<List<NewsBlock>> = service.articles()
    .map(Jsoup::parse)
    .map {
      it.select("div.item").select(".clearfix.inner").map {
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
}
