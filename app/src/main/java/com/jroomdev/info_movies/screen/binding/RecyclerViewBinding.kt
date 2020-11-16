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
package com.jroomdev.info_movies.screen.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jroomdev.info_movies.data.model.Movie
import com.jroomdev.info_movies.screen.adapter.MovieAdapter
import com.jroomdev.info_movies.screen.main.MainViewModel

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("paginationMovies")
fun paginationPokemonList(view: RecyclerView, viewModel: MainViewModel?) {
    viewModel?.fetchMovieList(1)
}

@BindingAdapter("movies")
fun setMovies(view: RecyclerView, movies: List<Movie>?) {
    movies?.let {
        (view.adapter as MovieAdapter).addMovieList(movies)
    }
}