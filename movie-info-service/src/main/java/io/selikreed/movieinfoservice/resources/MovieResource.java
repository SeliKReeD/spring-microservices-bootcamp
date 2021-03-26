package io.selikreed.movieinfoservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.selikreed.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    
    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable(name = "movieId") String movieId) {
        return new Movie(movieId, "Test name");       
    }
}
