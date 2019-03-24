package petproject.loskin.leonardo.features.profile.cities.mappers

import org.jsoup.Jsoup
import petproject.loskin.leonardo.base.db.dao.profile.City
import javax.inject.Inject

class CitiesMapper @Inject constructor() {
    fun page2Cities(page: String): List<City> = Jsoup.parse(page)
        .select("a.city_select")
        .map { City(it.attr("data-city"), it.text()) }
}
