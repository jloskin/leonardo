package petproject.loskin.leonardo.domain.main

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import petproject.loskin.leonardo.data.entity.MenuL
import petproject.loskin.leonardo.data.entity.news.competitions.CompetitionsBlock
import petproject.loskin.leonardo.data.entity.magazine.goods.GoodsData
import petproject.loskin.leonardo.data.entity.magazine.goods.Price
import petproject.loskin.leonardo.data.entity.magazine.subcategories.SubCategoriesData
import petproject.loskin.leonardo.data.entity.news.NewsBlock
import petproject.loskin.leonardo.repositories.MainRepositories

class MainInteractor(
        private val mainRepositories: MainRepositories
) {
    fun getGoods(url: String): Observable<List<GoodsData>> = mainRepositories.getUrl(url)
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .map(Jsoup::parse)
            .map {
                it.select(".gooditem").map {
                    val img = it.select(".image").select("a").select("img").attr("src")
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
                            "https:$img",
                            itemName,
                            urlItem
                    )
                }
            }

    fun getMenu(): Observable<List<MenuL>> = mainRepositories.getAllPhotos()
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .map(Jsoup::parse)
            .map {
                it.select(".cd-dropdown-content").first().children().map {
                    val a = it.children().first()
                    val blocks = it.children().select(".block").map(Element::children).map {
                        MenuL(
                                it.first().attr("href").replace(Regex(".+(tree_.+)/"), "$1"),
                                it.first().text(),
                                it.select("li").select("a").map {
                                    MenuL(
                                            it.attr("href").replace(Regex(".+(tree_.+)/"), "$1"),
                                            it.text()
                                    )
                                }
                        )
                    }
                    MenuL(
                            a.attr("href").replace(Regex(".+(tree_.+)/"), "$1"),
                            a.text(),
                            blocks
                    )
                }
            }

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


    fun load(item: String): Observable<List<SubCategoriesData>> = mainRepositories.getUrl(item)
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .map(Jsoup::parse)
            .map {
                it.select("div.main-column div.row div.content-wrapper div.row.adaptive-columns div.block")
                        .map { it.children().first() }
                        .map {
                            SubCategoriesData(
                                    "https://leonardohobby.ru${it.attr("href")}",
                                    it.text()
                            )
                        }
            }
}