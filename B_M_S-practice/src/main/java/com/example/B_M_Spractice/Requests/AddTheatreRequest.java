package com.example.B_M_Spractice.Requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTheatreRequest {

    private String name;

    private String address;

    private Integer noOfScreens;
}
