package petproject.loskin.leonardo.base.db.dao.shop

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable
import petproject.loskin.leonardo.base.db.dao.profile.City

@Dao
interface ShopDao {
    @Query("SELECT * FROM menus WHERE parentId = :item ORDER BY name")
    fun menus(item: String = ""): Flowable<List<MenuL>>

    @Query("SELECT * FROM menus")
    fun getAll(): Flowable<List<MenuL>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMenus(categories: List<MenuL>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCities(cities: List<City>)

    @Query("SELECT * FROM city ORDER BY title")
    fun getCities(): Flowable<List<City>>
}
