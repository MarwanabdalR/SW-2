package pl.edu.pw.PRK.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController {

    @ExceptionHandler
    public String handleException(Exception e, Model model){
        model.addAttribute("errorMessage",e.getMessage());
        model.addAttribute("status",HttpStatus.BAD_REQUEST.value());
        return "exceptions/exc";
    }
}
