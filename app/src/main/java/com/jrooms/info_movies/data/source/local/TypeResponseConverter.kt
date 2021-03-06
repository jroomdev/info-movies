/*
 * Copyright by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jrooms.info_movies.data.source.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.jrooms.info_movies.data.model.MovieInfo
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class TypeResponseConverter @Inject constructor(
  private val moshi: Moshi
) {

  @TypeConverter
  fun fromString(value: String): List<MovieInfo.Genres>? {
    val listType = Types.newParameterizedType(List::class.java, MovieInfo.Genres::class.java)
    val adapter: JsonAdapter<List<MovieInfo.Genres>> = moshi.adapter(listType)
    return adapter.fromJson(value)
  }

  @TypeConverter
  fun fromInfoType(type: List<MovieInfo.Genres>?): String {
    val listType = Types.newParameterizedType(List::class.java, MovieInfo.Genres::class.java)
    val adapter: JsonAdapter<List<MovieInfo.Genres>> = moshi.adapter(listType)
    return adapter.toJson(type)
  }
}
