package com.example.B_M_Spractice.Requests;

import lombok.Data;

@Data
public class AddTheaterSeatsRequest {

    private int noOfClassicSeats;
    private int noOfPremiumSeats;
    private int theaterId;
}
