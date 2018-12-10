package petproject.loskin.leonardo.data.mapper.authorization

import org.jsoup.Jsoup

class AuthorizationMapper {
  fun string2Response(page: String): List<Pair<String, String>> = Jsoup.parse(page)
    .select("div.profile_main_anketa div")
    .map { it.text().split(":") }
    .map { Pair(it.component1(), it.component2()) }
}