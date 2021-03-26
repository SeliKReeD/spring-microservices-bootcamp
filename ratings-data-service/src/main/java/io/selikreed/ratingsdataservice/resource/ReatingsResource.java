package io.selikreed.ratingsdataservice.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.selikreed.ratingsdataservice.model.Rating;

@RestController
@RequestMapping("/ratings")
public class ReatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable(name = "movieId") String movieId) {
        return new Rating(movieId, 4);
    }
    
}
