package com.example.B_M_Spractice.Requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMoviesAttribute {

    private Integer movieId;
    private double rating;
    private double duration;
}
