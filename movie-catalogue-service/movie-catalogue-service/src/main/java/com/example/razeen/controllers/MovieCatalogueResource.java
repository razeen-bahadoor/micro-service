package com.example.razeen.controllers;

import com.example.razeen.models.CatalogItem;
import com.example.razeen.models.Movie;
import com.example.razeen.models.Rating;
import com.example.razeen.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogueResource {

        @Autowired
        private RestTemplate template;
        @Autowired
        private WebClient.Builder webClientBuilder;

        @RequestMapping("/{userId}")
        public List<CatalogItem> getCatalog(@PathVariable("userId") String userId ){
            UserRating ratings = template.getForObject("http://localhost:8083/ratingsdata/users/" + userId, UserRating.class);

           return ratings.getUserRating().stream().map(rating -> {
              Movie movie = template.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
//
//               Movie movie = webClientBuilder.build()
//                        .get()
//                        .uri("http://localhost:8082/movies/" + rating.getMovieId())
//                        .retrieve()
//                        .bodyToMono(Movie.class)
//                        .block();

              return  new CatalogItem(movie.getName(), "Desc", movie.getRating());
           }).collect(Collectors.toList());





        }

}