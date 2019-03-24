package petproject.loskin.leonardo.base.db.dao.profile

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class City(
    @PrimaryKey val value: String,
    val title: String
)