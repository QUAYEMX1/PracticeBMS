package com.example.B_M_Spractice.Models;

import com.example.B_M_Spractice.Enums.Genre;
import com.example.B_M_Spractice.Enums.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="movies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Column(unique = true)
    private String movieName;

    private double duration;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

//    YY:MM:DD
    private LocalDate releaseDate;

    private double rating;
    @Enumerated(value = EnumType.STRING)
    private Language language;

}
