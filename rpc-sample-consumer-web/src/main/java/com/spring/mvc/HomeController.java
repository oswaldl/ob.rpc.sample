package com.spring.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import com.ob.service.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Resource
	private HelloService helloService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		String message = helloService.hello("oswaldl");
		
		model.addAttribute("message", message );
		
		return "home";
	}
	
}