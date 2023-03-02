package com.mroussy.mooviz_back.repository;

import com.mroussy.mooviz_back.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
