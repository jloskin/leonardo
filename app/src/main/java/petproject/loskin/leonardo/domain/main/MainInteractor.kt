package petproject.loskin.leonardo.domain.main

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import petproject.loskin.leonardo.data.entity.magazine.goods.GoodsData
import petproject.loskin.leonardo.data.entity.magazine.goods.Price
import petproject.loskin.leonardo.data.entity.news.NewsBlock
import petproject.loskin.leonardo.data.entity.news.competitions.CompetitionsBlock
import petproject.loskin.leonardo.repositories.MainRepositories

class MainInteractor(
        private val mainRepositories: MainRepositories
) {
    fun getNews(): Observable<List<NewsBlock>> = mainRepositories.getNews()
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

    fun getCompetitions(): Observable<List<CompetitionsBlock>> = mainRepositories.getCompetitions()
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

    fun getMClasses(): Observable<List<CompetitionsBlock>> = mainRepositories.getMClasses()
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

    fun getArticles(): Observable<List<NewsBlock>> = mainRepositories.getArticles()
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