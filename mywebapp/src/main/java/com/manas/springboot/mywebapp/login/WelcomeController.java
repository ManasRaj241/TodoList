package com.manas.springboot.mywebapp.login;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class WelcomeController {

//	private AuthenticationService authenticationService;

//	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name",getLoggedinUsername());
//		logger.info("Request Param is {}",name);
		return "welcome";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

//	@RequestMapping(value = "login", method = RequestMethod.POST)
//	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//		if (authenticationService.authenticate(name, password)) {
//			logger.info("Authentication passed");
//			model.put("password", password);
//			model.put("username", name);
//			return "welcome";
//		} else {
//			logger.info("auth failed");
//			model.put("errorMessage", "Please try Again");
//			return "login";
//		}
//	}
//
//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}
}
