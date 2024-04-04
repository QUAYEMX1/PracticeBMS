package com.example.B_M_Spractice.Service;

import com.example.B_M_Spractice.Models.Movie;
import com.example.B_M_Spractice.Repository.MovieRepository;
import com.example.B_M_Spractice.Requests.UpdateMoviesAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(Movie movie){

        movie=movieRepository.save(movie);

        return "The movie has been saved to the db "+movie.getMovieId();
    }

    public String updateMoviesAttribute(UpdateMoviesAttribute updateMoviesAttribute){

        Movie movie=movieRepository.findById(updateMoviesAttribute.getMovieId()).get();

        movie.setDuration(updateMoviesAttribute.getDuration());
        movie.setRating(updateMoviesAttribute.getRating());

        movieRepository.save(movie);

        return "The movie Attribute has been updated";
    }
}
