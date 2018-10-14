package petproject.loskin.leonardo.data.entity.magazine

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subcategories")
class SubCategoriesData(
        @PrimaryKey @ColumnInfo(name = "id") val itemUrl: String,
        val itemName: String
)