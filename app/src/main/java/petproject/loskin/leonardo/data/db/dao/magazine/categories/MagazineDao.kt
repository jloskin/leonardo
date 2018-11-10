/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package petproject.loskin.leonardo.data.db.dao.magazine.categories

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Flowable
import petproject.loskin.leonardo.data.entity.magazine.MenuL
import petproject.loskin.leonardo.data.mapper.magazine.categories.City

/**
 * The Data Access Object for the Plant class.
 */
@Dao
interface MagazineDao {
    @Query("SELECT * FROM menus WHERE parentId = :item ORDER BY name")
    fun getMenus(item: String = ""): Flowable<List<MenuL>>

    @Query("SELECT * FROM menus")
    fun getAll(): Flowable<List<MenuL>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMenus(categories: List<MenuL>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCities(cities: List<City>)

    @Query("SELECT * FROM city ORDER BY title")
    fun getCities(): Flowable<List<City>>
}
