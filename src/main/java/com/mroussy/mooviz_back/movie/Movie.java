package com.mroussy.mooviz_back.movie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;
    @Column(length = 50, nullable = false)
    @Getter @Setter private String title;
    @Column(length = 10, nullable = false)
    @Getter @Setter private String year;
    @Column(length = 50, nullable = false)
    @Getter @Setter private String director;
    @Column(length = 50, nullable = false)
    @Getter @Setter private String category;
}
