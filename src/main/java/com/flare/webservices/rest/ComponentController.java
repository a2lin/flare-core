package com.flare.webservices.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.flare.domain.Component;
import com.flare.domain.ComponentList;
import com.flare.services.ComponentService;

@Controller
public class ComponentController {
	@Autowired
	private ComponentService cs;
	
	@Autowired
	private View jsonView;
	
	private static final String DATA = "data";
	private static final String ERROR = "error";
	private static final Logger logger = Logger.getLogger(CourseController.class);
	
	public static boolean isEmpty(String s_p) {
		return (null == s_p) || s_p.trim().length() == 0;
	}

	private ModelAndView createErrorResponse(String sMessage) {
		return new ModelAndView(jsonView, ERROR, sMessage);
	}
	
	@RequestMapping(value = "/components/", method=RequestMethod.GET)
	public ModelAndView getAllComponents()
	{
		ComponentList cListObj;
		cListObj = cs.getAllComponents();
		return new ModelAndView(jsonView, DATA, cListObj);	
	}
	
	@RequestMapping(value = "/component/{sectid}", method=RequestMethod.GET)
	public ModelAndView getComponent(@PathVariable("sectid") String id)
	{
		Component c;
		c = cs.getComponent(id);
		return new ModelAndView(jsonView, DATA, c);
	}
	
}
