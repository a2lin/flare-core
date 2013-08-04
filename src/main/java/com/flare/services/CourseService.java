package com.flare.services;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.flare.domain.Course;
import com.flare.solrAccess.SolrSingleton;

@Service
public class CourseService {
	private static final Logger logger_c = Logger.getLogger(CourseService.class);
	private static final String uri_base = "http://ec2-54-213-31-81.us-west-2.compute.amazonaws.com:8983/solr/collection1/select?q=%2Bid:";
	private static final String uri_qsp = "&wt=json&indent=true";
	public SolrSingleton solr = SolrSingleton.getSolrSingleton();
	
	public Course getCourses()
	{
		Course c = new Course();
		solr.request(uri_base+uri_qsp);
		c.setCode("test");
		c.setId(13094);
		c.setProfessor("Magagna");
		c.setSubject("POLI");
		ArrayList<String> subL = new ArrayList<String>();
		subL.add("A1");
		subL.add("A2");
		subL.add("A3");
		c.setSublist(subL);
		return c;
	}
}
