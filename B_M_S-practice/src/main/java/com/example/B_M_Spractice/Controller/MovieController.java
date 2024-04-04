package com.example.B_M_Spractice.Controller;

import com.example.B_M_Spractice.Models.Movie;
import com.example.B_M_Spractice.Requests.UpdateMoviesAttribute;
import com.example.B_M_Spractice.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

   @PostMapping("/addmovie")
    public String addMovie(@RequestBody Movie movie){
        String ans=movieService.addMovie(movie);

        return ans;
   }

   @PutMapping("/updateMoviesAttribute")
    public String updateMoviesAttribute(@RequestBody UpdateMoviesAttribute updateMoviesAttribute){

      String ans=movieService.updateMoviesAttribute(updateMoviesAttribute);

      return ans;
   }




}
