package com.flare.webservices.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.flare.domain.Offering;
import com.flare.services.OfferingService;

@Controller
public class OfferingController {
	@Autowired
	private OfferingService os;
	
	@Autowired
	private View jsonView;
	
	private static final String DATA = "data";
	private static final String ERROR = "error";
	private static final Logger logger = Logger.getLogger(CourseController.class);
	
	public static boolean isEmpty(String s) {
		return (null == s) || s.trim().length() == 0;
	}

	private ModelAndView createErrorResponse(String message) {
		return new ModelAndView(jsonView, ERROR, message);
	}
	
	@RequestMapping(value = "/classes/", method=RequestMethod.GET)
	public ModelAndView getAllClasses()
	{
		List<Offering> offerings;
		
		//TODO try/catch this so we don't blow up if we get exception.
		offerings = os.getAllClasses();
		return new ModelAndView(jsonView, DATA, offerings);
		
	}
}