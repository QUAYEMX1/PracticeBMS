package com.example.B_M_Spractice.Controller;

import com.example.B_M_Spractice.Requests.AddTheaterSeatsRequest;
import com.example.B_M_Spractice.Requests.AddTheatreRequest;
import com.example.B_M_Spractice.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Theatre")
public class TheatreController {
    @Autowired
    private TheatreService theatreService;



    @PostMapping("/addTheatre")
    public String addTheatre(@RequestBody AddTheatreRequest addTheatreRequest){

       String res=theatreService.addTheatre(addTheatreRequest);
       return res;
    }

    @PostMapping("addTheaterSeats")
    public String addTheaterSeats(@RequestBody AddTheaterSeatsRequest addTheaterSeatsRequest){

        String res=theatreService.addTheaterSeats(addTheaterSeatsRequest);
        return res;
    }
}
