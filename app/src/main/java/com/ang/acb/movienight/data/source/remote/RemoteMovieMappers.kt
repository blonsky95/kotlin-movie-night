package com.ang.acb.movienight.data.source.remote

import com.ang.acb.movienight.data.source.remote.response.MoviesResponse
import com.ang.acb.movienight.data.source.remote.response.NetworkMovie
import com.ang.acb.movienight.data.source.remote.response.NetworkMovieDetails
import com.ang.acb.movienight.domain.entities.*

fun MoviesResponse.asMovies() = Movies(
    movies = results.map { it.asMovie() },
    currentPage = page,
    totalPages = totalPages
)

fun NetworkMovie.asMovie() = Movie(
    id = id,
    title = title,
    overview = overview,
    releaseDate = releaseDate,
    posterPath = posterPath,
    backdropPath = backdropPath,
    popularity = popularity,
    voteAverage = voteAverage,
    voteCount = voteCount,
)

fun NetworkMovieDetails.asMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        releaseDate = releaseDate,
        posterPath = posterPath,
        backdropPath = backdropPath,
        popularity = popularity,
        voteAverage = voteAverage,
        voteCount = voteCount,
    )
}

fun NetworkMovieDetails.asGenres(): List<Genre> {
    return genres.map {
        Genre(
            id = it.id,
            movieId = id,
            name = it.name
        )
    }.toList()
}

fun NetworkMovieDetails.asCast(): List<Cast> {
    return creditsResponse.cast.map {
        Cast(
            id = it.id,
            movieId = id,
            actorName = it.actorName,
            profileImagePath = it.profileImagePath
        )
    }.toList()
}

fun NetworkMovieDetails.asVideos(): List<Trailer> {
    return videosResponse.videos.map {
        Trailer(
            id = it.id,
            movieId = id,
            key = it.key,
            name = it.name
        )
    }.toList()
}

fun NetworkMovieDetails.asMovieDetails(): MovieDetails {
    return MovieDetails(
        movie = asMovie(),
        genres = asGenres(),
        cast = asCast(),
        trailers = asVideos(),
    )
}