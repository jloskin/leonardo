package petproject.loskin.leonardo.features.profile

import org.jsoup.Jsoup
import javax.inject.Inject

class ProfileMapper @Inject constructor() {
    fun page2Response(page: String): List<Pair<String, String>> = Jsoup.parse(page)
        .select("div.profile_main_anketa div")
        .map { it.text().split(":") }
        .map { Pair(it.component1(), it.component2()) }
}