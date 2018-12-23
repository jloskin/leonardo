package petproject.loskin.leonardo.domain.model.main

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.jsoup.Jsoup
import petproject.loskin.leonardo.data.entity.news.NewsBlock
import petproject.loskin.leonardo.data.entity.news.competitions.CompetitionsBlock
import petproject.loskin.leonardo.domain.repositories.news.LeisureRepositories

class LeisureInteractor(
  private val leisureRepositories: LeisureRepositories
) {
  fun getNews(): Observable<List<NewsBlock>> = leisureRepositories.getNews()
    .subscribeOn(Schedulers.io())
    .unsubscribeOn(Schedulers.io())
    .observeOn(Schedulers.io())
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

  fun getCompetitions(): Observable<List<CompetitionsBlock>> = leisureRepositories.getCompetitions()
    .subscribeOn(Schedulers.io())
    .unsubscribeOn(Schedulers.io())
    .observeOn(Schedulers.io())
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

  fun getMClasses(): Observable<List<CompetitionsBlock>> = leisureRepositories.getMClasses()
    .subscribeOn(Schedulers.io())
    .unsubscribeOn(Schedulers.io())
    .observeOn(Schedulers.io())
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

  fun getArticles(): Observable<List<NewsBlock>> = leisureRepositories.getArticles()
    .subscribeOn(Schedulers.io())
    .unsubscribeOn(Schedulers.io())
    .observeOn(Schedulers.io())
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