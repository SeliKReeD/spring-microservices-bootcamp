package io.selikreed.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.selikreed.model.CatalogItem;
import io.selikreed.model.Movie;
import io.selikreed.model.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;
    
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable(name = "userId") String userId) {

        List<Rating> ratings = Arrays.asList(
            new Rating("1234", 5),
            new Rating("6789", 1)
        );

        return ratings.stream().map(
            rating ->  {
                Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
                return new CatalogItem(movie.getName(), "Test", rating.getRating());
            }
        ).collect(Collectors.toList());
    }
}
