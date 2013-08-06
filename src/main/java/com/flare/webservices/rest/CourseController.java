package com.flare.webservices.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.flare.domain.Course;
import com.flare.services.CourseService;

@Controller
public class CourseController {
	@Autowired
	private CourseService cs_i;
	
	@Autowired
	private View jsonView_i;
	
	private static final String DATA_FIELD = "data";
	private static final String ERROR_FIELD = "error";
	private static final Logger logger_c = Logger.getLogger(CourseController.class);
	
	public static boolean isEmpty(String s_p) {
		return (null == s_p) || s_p.trim().length() == 0;
	}

	private ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(jsonView_i, ERROR_FIELD, sMessage);
	}
	
	@RequestMapping(value = "/course/", method=RequestMethod.GET)
	public ModelAndView getSubList()
	{
		Course c = null;
		try{
			c = cs_i.getCourses();
		}
		catch(Exception e){
			  String sMessage = "Error invoking getFund. [%1$s]";  
			  return createErrorResponse(String.format(sMessage, e.toString()));  
		}
		logger_c.debug("Returning Fund: " + c.toString());  
		System.err.println("watup");
		return new ModelAndView(jsonView_i, DATA_FIELD, c);  
	}
	
	@RequestMapping(value = "/courses/", method=RequestMethod.GET)
	public ModelAndView getCourse()
	{
		Course c = null;
		try{
			c = cs_i.getCourses();
		}
		catch(Exception e){
			  String sMessage = "Error invoking getFund. [%1$s]";  
			  return createErrorResponse(String.format(sMessage, e.toString()));  
		}
		logger_c.debug("Returning Fund: " + c.toString());  
		System.err.println("watup");
		return new ModelAndView(jsonView_i, DATA_FIELD, c);  
	}
	
//	@RequestMapping(value = "*", method=RequestMethod.GET)
//	public ModelAndView generic()
//	{
//		String sMessage = "problem";
//		return createErrorResponse(String.format(sMessage));
//	}
	
}
