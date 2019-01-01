package petproject.loskin.leonardo.data.mapper.profile

import org.jsoup.Jsoup
import petproject.loskin.leonardo.presentation.ui.profile.myprofile.ProfileData

class MyProfileMapper {
  fun string2ProfileData(page: String): List<ProfileData> = Jsoup.parse(page)
    .select("div.profile_main_anketa div")
    .map { ProfileData(it.html().split(":").component1(), it.select("span").text()) }
}
