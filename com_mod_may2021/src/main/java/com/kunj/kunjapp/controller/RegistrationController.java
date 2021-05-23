package com.kunj.kunjapp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kunj.kunjapp.dto.RegistrationDTO;
import com.kunj.kunjapp.service.RegistrationService;

@Controller
@RequestMapping("/")
public class RegistrationController {

	private static Logger logger;
	
	@Autowired
	private RegistrationService registrationService;

	public RegistrationController() {
		logger = Logger.getLogger(getClass());
		
	}

	@RequestMapping("/registration.mod")
	@PostMapping
	public ModelAndView register(RegistrationDTO registrationDTO) {
		logger.info("invoking register()");
		ModelAndView modelAndView = new ModelAndView("index");
		try {
			String msg = registrationService.validateAndSave(registrationDTO);
			modelAndView.addObject("msg", msg + registrationDTO.getFullName());
			
		} catch (Exception e) {
			logger.error("you have an exception in " + e.getMessage(), e);
		}

		return modelAndView;
	}
}
