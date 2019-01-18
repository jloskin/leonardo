package petproject.loskin.leonardo.data.db.dao.profile

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
  @PrimaryKey val login: String,
  val password: String
)