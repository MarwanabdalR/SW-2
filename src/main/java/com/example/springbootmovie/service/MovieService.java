package com.example.springbootmovie.service;

import com.example.springbootmovie.model.Movie;
import com.example.springbootmovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie getMovieById(int id){
        Optional<Movie> optional = movieRepository.findById(id);
        Movie movie = null;
        if (optional.isPresent()){
            movie = optional.get();
        }else{
            throw new RuntimeException("Movie not found for id ::" + id);
        }
        return movie;
    }

    public void deleteMovie(int id){
        movieRepository.deleteById(id);
    }

    public List<Movie> findByKeyword(String keyword){
        return movieRepository.findByKeyword(keyword);
    }
}
