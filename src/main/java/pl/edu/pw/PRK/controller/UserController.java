package pl.edu.pw.PRK.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.pw.PRK.service.SoldTicketsService;
import pl.edu.pw.PRK.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final SoldTicketsService soldTicketsService;

    @Autowired
    public UserController(UserService userService, SoldTicketsService soldTicketsService) {
        this.userService=userService;
        this.soldTicketsService=soldTicketsService;
    }

    @GetMapping("/menu")
    public String userMenu(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("userName", authentication.getName());
        if (authentication.getName().equals("anonymousUser")){
            model.addAttribute("userAuthorities","none");
        } else {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            model.addAttribute("userAuthorities", userDetails.getAuthorities());
        }

        return "user/userMenu";
    }

    @GetMapping("/data")
    public String userData(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("user",userService.findByUserName(authentication.getName()));
        return "user/userData";
    }

    @GetMapping("/reservations")
    public String userReservation(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("listOfTickets",soldTicketsService.findTicketListForTheUser(userService.findByUserName(authentication.getName())));
        return "user/userReservations";
    }

    @GetMapping("/deleteReservation")
    public String userDeleteReservation(@RequestParam("ticketId") int ticketID){
        soldTicketsService.findById(ticketID).getMovieSeat().setOccupied(false);
        soldTicketsService.deleteById(ticketID);
        return "redirect:/user/reservations";
    }

    @GetMapping("/updateData")
    public String updateUserData(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("user",userService.findByUserName(authentication.getName()));
        return "register/updateForm";
    }
}
