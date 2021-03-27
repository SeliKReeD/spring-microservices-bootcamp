package io.selikreed.ratingsdataservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.selikreed.ratingsdataservice.model.Rating;
import io.selikreed.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("/ratings")
public class ReatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable(name = "movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getRatings(@PathVariable(name = "userId") String userId) {
        return new UserRating(Arrays.asList(
            new Rating("1234", 5),
            new Rating("6789", 1)
        ));
    }
}
