package pl.edu.pw.PRK.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.PRK.entity.MovieSeats;
import pl.edu.pw.PRK.entity.SoldTicket;
import pl.edu.pw.PRK.entity.Ticket;
import pl.edu.pw.PRK.service.*;
import java.util.List;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    private final MovieSeatsService movieSeatsService;
    private final TicketService ticketService;
    private final ScheduleOfMoviesService scheduleOfMoviesService;
    private final SoldTicketsService soldTicketsService;
    private final UserService userService;

    @Autowired
    public ReservationController(MovieSeatsService movieSeatsService,TicketService ticketService, ScheduleOfMoviesService scheduleOfMoviesService,
                                 SoldTicketsService soldTicketsService, UserService userService){
        this.movieSeatsService=movieSeatsService;
        this.ticketService=ticketService;
        this.scheduleOfMoviesService=scheduleOfMoviesService;
        this.soldTicketsService=soldTicketsService;
        this.userService=userService;
    }

    @GetMapping("/prepareReservation")
    public String prepareReservation(@RequestParam("selectedMovie") int selectedMovie, Model model){

        //pass list of unoccupied seats
        List<MovieSeats> movieSeatsNotOccupiedList = movieSeatsService.findNotOccupiedSeats(scheduleOfMoviesService.findById(selectedMovie));
        model.addAttribute("listOfSeats",movieSeatsNotOccupiedList);

        //pass lost of tickets
        List<Ticket> listOfTickets = ticketService.findAll();
        model.addAttribute("listOfTickets",listOfTickets);

        //create new soldTicket
        SoldTicket soldTicket = new SoldTicket();

        //past new soldTicket
        model.addAttribute("soldTicket",soldTicket);

        return "reservation/showReservationForm";
    }

    @PostMapping("/addSoldTicket")
    public String addSoldTicket(@ModelAttribute("soldTicket") SoldTicket soldTicket, Model model){
        if (soldTicketsService.checkIfTicketIsSold(soldTicket.getMovieSeat())) {
            model.addAttribute("seatIsOccupied", true);
            List<MovieSeats> movieSeatsNotOccupiedList = movieSeatsService.findNotOccupiedSeats(scheduleOfMoviesService.findById(soldTicket.getMovieSeat().getScheduleOfMovieId().getId()));
            model.addAttribute("listOfSeats",movieSeatsNotOccupiedList);
            List<Ticket> listOfTickets = ticketService.findAll();
            model.addAttribute("listOfTickets",listOfTickets);
            return "reservation/showReservationForm";
        } else {
            model.addAttribute("seatIsOccupied", false);
            //add user
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            soldTicket.setUser(userService.findByUserName(authentication.getName()));
            //save soldTicket
            soldTicketsService.save(soldTicket);
            //set occupation to movieSeat
            MovieSeats movieSeats = movieSeatsService.findById(soldTicket.getMovieSeat().getId());
            movieSeats.setOccupied(true);
            movieSeatsService.save(movieSeats);
            return "redirect:/user/reservations";
        }
    }










}
