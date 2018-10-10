package petproject.loskin.leonardo.domain.main

import io.reactivex.schedulers.Schedulers
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import petproject.loskin.leonardo.data.entity.ItemL
import petproject.loskin.leonardo.data.entity.MenuL
import petproject.loskin.leonardo.data.entity.Price
import petproject.loskin.leonardo.data.entity.competitions.CompetitionsBlock
import petproject.loskin.leonardo.data.entity.news.NewsBlock
import petproject.loskin.leonardo.repositories.MainRepositories
import javax.inject.Inject

class MainInteractor @Inject constructor(
        private val mainRepositories: MainRepositories
) {
    fun getGoods(url: String) = mainRepositories.getUrl(url)
            .subscribeOn(Schedulers.io())
            .map(Jsoup::parse)
            .unsubscribeOn(Schedulers.io())
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
                    ItemL(
                            "https:$img",
                            itemName,
                            urlItem,
                            prices.second,
                            prices.first
                    )
                }
            }

    fun getMenu() = mainRepositories.getAllPhotos()
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

    fun getNews() = mainRepositories.getNews()
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

    fun getCompetitions() = mainRepositories.getCompetitions()
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

    fun getMClasses() = mainRepositories.getMClasses()
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

    fun getArticles() = mainRepositories.getArticles()
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

    fun loadGoodsCategories() = mainRepositories.loadGoodsCategories()
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .map(Jsoup::parse)
            .map {
                it.select("div.ishop-half-block").map {
                    val title = it.select("div.name a")
                    GoodsCategories(
                            "https://leonardohobby.ru${it.select("img").attr("src")}",
                            title.text(),
                            "https://leonardohobby.ru${title.attr("href")}"
                    )
                }
            }

    fun load(item: String) = mainRepositories.getUrl(item)
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .map(Jsoup::parse)
            .map {
                it.select("div.main-column div.row div.content-wrapper div.row.adaptive-columns div.block")
                        .map { it.children().first() }
                        .map {
                            ItemMagazine(
                                    "https://leonardohobby.ru${it.attr("href")}",
                                    it.text()
                            )
                        }
            }
}