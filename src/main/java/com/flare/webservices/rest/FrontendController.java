package com.flare.webservices.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FrontendController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHome()
	{
		return "frontend";
	}
}
