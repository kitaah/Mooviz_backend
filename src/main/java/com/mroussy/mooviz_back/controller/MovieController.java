package com.mroussy.mooviz_back.controller;

import com.mroussy.mooviz_back.exception.MovieNotFoundException;
import com.mroussy.mooviz_back.movie.Movie;
import com.mroussy.mooviz_back.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("http://localhost:3000")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("/addmovie")
    Movie newMovie(@RequestBody Movie newMovie) { return movieRepository.save(newMovie);}

    @GetMapping("/getmovies")
    List<Movie> getAllMovies() { return movieRepository.findAll();}

    @GetMapping("/getmovie/{id}")
    Movie getMovieById(@PathVariable Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    @PutMapping("/updatemovie/{id}")
    Movie updateMovie(@RequestBody Movie newMovie, @PathVariable Long id){
        return movieRepository.findById(id)
                .map(movie -> {
                    movie.setTitle(newMovie.getTitle());
                    movie.setYear(newMovie.getYear());
                    movie.setDirector(newMovie.getDirector());
                    movie.setCategory(newMovie.getCategory());
                    return movieRepository.save(movie);
                }).orElseThrow(() -> new MovieNotFoundException(id));
    }

    @DeleteMapping("deletemovie/{id}")
    String deleteMovie(@PathVariable Long id){
        if(!movieRepository.existsById(id)) {
            throw new MovieNotFoundException(id);
        }
        movieRepository.deleteById(id);
        return "Le film avec l'id " + id + " a été correctement supprimé.";
    }
}
