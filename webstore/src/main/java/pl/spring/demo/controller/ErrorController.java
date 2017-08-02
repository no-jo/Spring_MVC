package pl.spring.demo.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.spring.demo.constants.ModelConstants;

@Controller
@RequestMapping (value = "/accessDenied")
public class ErrorController {
	
	@RequestMapping
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject(ModelConstants.ERROR_MESSAGE, "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject(ModelConstants.ERROR_MESSAGE,
			"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

}
