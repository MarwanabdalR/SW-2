package pl.edu.pw.PRK.controller;

import pl.edu.pw.PRK.entity.User;
import pl.edu.pw.PRK.service.UserService;
import pl.edu.pw.PRK.entity.WebUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	private final Logger logger = Logger.getLogger(getClass().getName());

    private final UserService userService;

	@Autowired
	public RegistrationController(UserService userService) {
		this.userService = userService;
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}	
	
	@GetMapping("/showRegistrationForm")
	public String showRegistrationForm(Model theModel) {
		
		theModel.addAttribute("webUser", new WebUser());
		
		return "register/registrationForm";
	}

	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(
			@Valid @ModelAttribute("webUser") WebUser webUser,
			HttpSession session, BindingResult theBindingResult,
			Model theModel) {
		
		String userName = webUser.getUserName();
		logger.info("Processing registration form for: " + userName);
		
		// form validation
		 if (theBindingResult.hasErrors()){
			 logger.info("Binding error during adding user.");
			 return "register/registrationForm";
	        }

		// check the database if user already exists
		 User existing = userService.findByUserName(userName);
        if (existing != null){
        	theModel.addAttribute("webUser", new WebUser());
			theModel.addAttribute("userAlreadyExist", true);

        	return "register/registrationForm";
        }
        
        // create user account and store in the database
        userService.save(webUser);
        
        logger.info("Successfully created user: " + userName);

		// place user in the web http session for later use
		session.setAttribute("user", webUser);
		theModel.addAttribute("userAlreadyExist", false);
        return "register/registrationConfirmation";
	}

	@PostMapping("/updateUser")
	public String updateUser(@Valid @ModelAttribute("user") User user) {

		User currentUser = userService.findByUserName(user.getUserName());

		if (user.getPassword() == null) {
			user.setPassword(currentUser.getPassword());
		}

		// create user account and store in the database
		userService.updateData(user);

		return "user/userData";
	}
}
