package com.mroussy.mooviz_back.movie;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;
    @Column(length = 50, nullable = false)
    @Getter @Setter private String name;
}
