package petproject.loskin.leonardo.base.db.dao.profile

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface CitiesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCities(cities: List<City>)

    @Query("SELECT * FROM city ORDER BY title")
    fun cities(): Flowable<List<City>>
}
