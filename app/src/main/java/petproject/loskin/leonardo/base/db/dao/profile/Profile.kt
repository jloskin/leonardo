package petproject.loskin.leonardo.base.db.dao.profile

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Profile(
    @PrimaryKey val login: String,
    val password: String
)