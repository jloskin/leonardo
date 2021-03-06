package petproject.loskin.leonardo.features.shop.goods.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "goods")
data class GoodsData(
    val img: String,
    val itemName: String,
    @PrimaryKey @ColumnInfo(name = "id") val urlItem: String
)
