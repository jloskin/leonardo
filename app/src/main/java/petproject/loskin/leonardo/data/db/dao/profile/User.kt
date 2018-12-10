package petproject.loskin.leonardo.data.db.dao.profile

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
  @PrimaryKey @ColumnInfo(name = "id") val id: Long,
  val username: String,
  val avatar: String
)