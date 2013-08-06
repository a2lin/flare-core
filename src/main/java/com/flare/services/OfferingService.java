package com.flare.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.springframework.stereotype.Service;

import com.flare.domain.Offering;
import com.flare.solrAccess.SolrSingleton;

@Service
public class OfferingService {
	private static final Logger logger_c = Logger.getLogger(CourseService.class);
	private static final String uri_base = "http://ec2-54-213-31-81.us-west-2.compute.amazonaws.com:8983/solr/collection1/select?q=";
//	private static final String uri_base = "http://localhost:8983/solr/collection1/select?q=";
	private static final String uri_qsp = "&wt=json&indent=true&rows=99999";
	public SolrSingleton solr = SolrSingleton.getSolrSingleton();
	
	
	/**
	 * Expensive call! (don't expose?)
	 * 
	 * @return
	 */
	//TODO Cache in Database?
	
	public List<Offering> getAllClasses() {
		JsonNode node;
		node = solr.request(uri_base+"*:*"+uri_qsp);
		
		//get response
		node = node.get("response");
		
		//get docs
		node = node.get("docs");
		
		System.out.println(node.size());
		HashSet<String> hs= new HashSet<String>();
		List<Offering> li_of = new ArrayList<Offering>();
		for(int i = 0; i < node.size(); i++)
		{
			hs.add(node.get(i).get("cid").toString());			
		}
		
		for(String s: hs)
		{
			ArrayList<String> lectures = new ArrayList<String>();
			ArrayList<String> discussions = new ArrayList<String>();
			ArrayList<String> seminars = new ArrayList<String>();
			ArrayList<String> labs = new ArrayList<String>();
			ArrayList<String> tutorials = new ArrayList<String>();
			ArrayList<String> other = new ArrayList<String>();
			String id = s;
			String subject = "";
			String code = "";
				
			JsonNode element = solr.request(uri_base+"%2Bcid:"+s+uri_qsp);
			element = element.get("response");
			element = element.get("docs");
			subject = element.get(0).get("subjcode").toString();
			code = element.get(0).get("courseno").toString();
			
			for(int i = 0;  i < element.size(); i++)
			{
				if(element.get(i).get("doctype").toString().equals("LE"))
				{
					lectures.add(element.get(i).get("id").toString());
				}
				else if(element.get(i).get("doctype").toString().equals("DI"))
				{
					discussions.add(element.get(i).get("id").toString());
				}
				else if(element.get(i).get("doctype").toString().equals("SE"))
				{
					seminars.add(element.get(i).get("id").toString());
				}
				else if(element.get(i).get("doctype").toString().equals("LA"))
				{
					labs.add(element.get(i).get("id").toString());
				}
				else if(element.get(i).get("doctype").toString().equals("TU")) 
				{
					tutorials.add(element.get(i).get("id").toString());
				}
				else 
				{
					other.add(element.get(i).get("id").toString());
				}
			}
			
			Offering of = new Offering();
			of.setCode(code);
			of.setId(id);
			of.setSubject(subject);
			of.setDiscussions(discussions);
			of.setLabs(labs);
			of.setLectures(lectures);
			of.setSeminars(seminars);
			of.setTutorials(tutorials);
			of.setOther(other);
			li_of.add(of);
		}
//		System.out.println(node);
		return li_of;
	}
}
