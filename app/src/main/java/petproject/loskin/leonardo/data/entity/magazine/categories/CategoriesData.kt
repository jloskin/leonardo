package petproject.loskin.leonardo.data.entity.magazine.categories

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoriesData(
        val imageUrl: String,
        val categoryName: String,
        @PrimaryKey @ColumnInfo(name = "id")  val categoryLink: String
)