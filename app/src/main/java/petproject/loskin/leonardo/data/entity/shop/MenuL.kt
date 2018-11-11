package petproject.loskin.leonardo.data.entity.shop

import androidx.room.Entity

@Entity(tableName = "menus", primaryKeys = ["url", "parentId"])
data class MenuL(
        val url: String,
        val name: String,
        val parentId: String = ""
) {
    fun image(): String = "https://leonardohobby.ru/images/prepics/" + url.replace("_", "") + ".jpg"
}