package com.example.B_M_Spractice.Service;
import com.example.B_M_Spractice.Enums.SeatType;
import com.example.B_M_Spractice.Models.TheaterSeat;
import com.example.B_M_Spractice.Models.Theatre;
import com.example.B_M_Spractice.Repository.TheatreRepository;
import com.example.B_M_Spractice.Repository.TheatreSeatRepository;
import com.example.B_M_Spractice.Requests.AddTheaterSeatsRequest;
import com.example.B_M_Spractice.Requests.AddTheatreRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private TheatreSeatRepository theatreSeatRepository;


    public String addTheatre(AddTheatreRequest addTheatreRequest){
        //addTheatreRequest ->name,address,noOfScreen
//        Theatre theatre=new Theatre();
//        theatre.setAddress(addTheatreRequest.getAddress());
//        theatre.setName(addTheatreRequest.getName());
//        theatre.setNoOfScreens(addTheatreRequest.getNoOfScreens());

        Theatre theatre=Theatre.builder()
                .noOfScreens(addTheatreRequest.getNoOfScreens())
                .address(addTheatreRequest.getAddress())
                .name(addTheatreRequest.getName())
                .build();

        theatre=theatreRepository.save(theatre);

        return "The theatre has been created"+theatre.getTheaterId();
    }

    public String addTheaterSeats(AddTheaterSeatsRequest addTheaterSeatsRequest) {

        Theatre theatre = theatreRepository.findById(addTheaterSeatsRequest.getTheaterId()).get();

        int noOfClassic = addTheaterSeatsRequest.getNoOfClassicSeats();
        int noOfPremium = addTheaterSeatsRequest.getNoOfPremiumSeats();

        List<TheaterSeat> theaterSeatList = new ArrayList<>();

        //theater Seat->seatNo
        //     ->seatType
        //  ->theatre

        int cnt = 1;
        char ch = 'A';
        int row = 1;

        while (cnt <= noOfClassic) {

            String seatNo = row + "" + ch;

            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .theatre(theatre)
                    .build();

            theaterSeatList.add(theaterSeat);

            ch++;

            if (cnt % 5 == 0) {
                ch = 'A';
                row++;
            }
            cnt++;
        }


        cnt = 1;
        row = row + 1;
        ch = 'A';

        while (cnt <= noOfPremium) {

            String seatNo = row + "" + ch;

            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .theatre(theatre)
                    .build();

            theaterSeatList.add(theaterSeat);

            ch++;

            if (cnt % 5 == 0) {
                ch = 'A';
                row++;
            }
            cnt++;
        }

        theatreSeatRepository.saveAll(theaterSeatList);

        return "The theatre Seat has been generated Successfully";
    }

}

