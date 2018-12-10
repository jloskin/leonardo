package petproject.loskin.leonardo.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import petproject.loskin.leonardo.data.db.dao.magazine.categories.ShopDao
import petproject.loskin.leonardo.data.db.dao.profile.ProfileDao
import petproject.loskin.leonardo.data.db.dao.profile.User
import petproject.loskin.leonardo.data.entity.shop.City
import petproject.loskin.leonardo.data.entity.shop.MenuL

@Database(entities = [MenuL::class, City::class, User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
  abstract fun categoriesDao(): ShopDao
  abstract fun profileDao(): ProfileDao

  companion object {
    @Volatile
    private var instance: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase =
      instance ?: synchronized(this) {
        instance ?: buildDatabase(context).also { instance = it }
      }

    private fun buildDatabase(context: Context): AppDatabase =
      Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()

    private const val DATABASE_NAME = "LEONARDO"
  }
}
