package petproject.loskin.leonardo.base.db.dao.profile

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profile")
    fun getUser(): Flowable<List<Profile>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(profile: Profile)
}