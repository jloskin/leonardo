package petproject.loskin.leonardo.features.profile.myprofile

import org.jsoup.Jsoup
import javax.inject.Inject

class MyProfileMapper @Inject constructor() {
    fun page2ProfileData(page: String): List<ProfileData> = Jsoup.parse(page)
        .select("div.profile_main_anketa div")
        .map { ProfileData(it.html().split(":").component1(), it.select("span").text()) }
}
