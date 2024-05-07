package pl.edu.pw.PRK.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.edu.pw.PRK.entity.ScheduleOfMovie;
import pl.edu.pw.PRK.service.ScheduleOfMoviesService;

@Controller
public class HomeController {

    private final ScheduleOfMoviesService scheduleOfMoviesService;

    @Autowired
    public HomeController(ScheduleOfMoviesService scheduleOfMoviesService) {
        this.scheduleOfMoviesService = scheduleOfMoviesService;
    }

    @GetMapping("/home")
    public String showHome(Model model){

        //send authorities to main page
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("userName", authentication.getName());
        if(authentication.getName().equals("anonymousUser")){
            model.addAttribute("userAuthorities","none");
        } else {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            model.addAttribute("userAuthorities", userDetails.getAuthorities());
        }

        //show all scheduled movies
        model.addAttribute("scheduledMovies", scheduleOfMoviesService.findAllSortedByDateAndTime());

        return "home";
    }

    @GetMapping("/home/search")
    public ModelAndView searchMovie (@RequestParam("movieName") String theName, Model theModel) {

        //send authorities to main page
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        theModel.addAttribute("userName", authentication.getName());
        if(authentication.getName().equals("anonymousUser")){
            theModel.addAttribute("userAuthorities","none");
        } else {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            theModel.addAttribute("userAuthorities", userDetails.getAuthorities());
        }

        List <ScheduleOfMovie> scheduleOfMoviesFound = scheduleOfMoviesService.searchBy(theName);

        theModel.addAttribute("scheduledMovies", scheduleOfMoviesFound);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("home");

        return modelAndView;
    }

//    @GetMapping("/chooseLanguage")
//    public String chooseLanguage(){
//        return "chooseLanguage";
//    }
}
