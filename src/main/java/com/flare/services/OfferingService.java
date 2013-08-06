package com.flare.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import com.flare.domain.Offering;
import com.flare.solrAccess.SolrSingleton;

@Service
public class OfferingService {
	private static final Logger logger_c = Logger.getLogger(CourseService.class);
//	private static final String uri_base = "http://ec2-54-213-31-81.us-west-2.compute.amazonaws.com:8983/solr/collection1/select?q=";
	private static final String uri_base = "http://localhost:8983/solr/collection1/select?q=";
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
		node = solr.request(uri_base+"%2Btype%3A+offering"+uri_qsp);
		System.out.println(uri_base+"%2Btype%3A+offering"+uri_qsp);
		
		//get response
		node = node.get("response");
		
		//get docs
		node = node.get("docs");
		List<Offering> li_of = new ArrayList<Offering>();
		ObjectMapper mapper = new ObjectMapper();
		
		for(int i = 0; i< node.size(); i++)
		{
			Offering of = null;
			try {
				of = mapper.readValue(node.get(i).toString(), Offering.class);
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(of != null)
			{
				System.out.println(of.getLecture());
				System.out.println(of.getDiscussion());
				li_of.add(of);
			}
		}
		
//		System.out.println(node);
		return li_of;
	}
}
