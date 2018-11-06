package petproject.loskin.leonardo.data.mapper.magazine.categories

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class City(
        @PrimaryKey val value: String,
        val title: String
)