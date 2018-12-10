package petproject.loskin.leonardo.data.db.dao.profile

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface ProfileDao {
  @Query("SELECT * FROM user")
  fun getUser(): Flowable<List<User>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertUser(user: User)
}