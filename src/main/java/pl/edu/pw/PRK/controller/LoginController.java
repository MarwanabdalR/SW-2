package pl.edu.pw.PRK.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String showLoginPage(){
        return "loginPage";
    }

    @GetMapping("/accessDenied")
    public String showAccessDeniedPage(){
        return "accessDenied";
    }
}
