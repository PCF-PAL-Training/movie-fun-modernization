package org.superbiz.moviefun;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.superbiz.moviefun.albumsapi.AlbumsClient;
import org.superbiz.moviefun.moviesapi.MoviesClient;

@Configuration
public class ClientConfiguration {

    @Value("${albums.url}") String albumsUrl;
    @Value("${movies.url}") String moviesUrl;

    @Bean
    public AlbumsClient albumsClient(RestOperations restTemplate) {
        return new AlbumsClient(albumsUrl, restTemplate);
    }

    @Bean
    public MoviesClient moviesClient(RestOperations restTemplate) {
        return new MoviesClient(moviesUrl, restTemplate);
    }
}