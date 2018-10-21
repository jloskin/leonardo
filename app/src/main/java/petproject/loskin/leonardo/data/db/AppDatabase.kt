package petproject.loskin.leonardo.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import petproject.loskin.leonardo.data.db.dao.magazine.categories.CategoriesDao
import petproject.loskin.leonardo.data.entity.magazine.categories.CategoriesData
import petproject.loskin.leonardo.data.entity.magazine.goods.GoodsData
import petproject.loskin.leonardo.data.entity.magazine.subcategories.SubCategoriesData

@Database(entities = [CategoriesData::class, GoodsData::class, SubCategoriesData::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoriesDao(): CategoriesDao

    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
                instance ?: synchronized(this) {
                    instance ?: buildDatabase(context).also { instance = it }
                }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                    .build()
        }

        const val DATABASE_NAME = "LEONARDO"
    }
}
