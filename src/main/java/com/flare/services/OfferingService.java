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
import com.flare.domain.OfferingList;
import com.flare.solrAccess.SolrSingleton;

@Service
public class OfferingService {
	private static final Logger logger_c = Logger.getLogger(CourseService.class);
	private static final String uri_base = "http://ec2-54-213-31-81.us-west-2.compute.amazonaws.com:8983/solr/collection1/select?q=";
//	private static final String uri_base = "http://localhost:8983/solr/collection1/select?q=";
	private static final String uri_qsp = "&wt=json&indent=true&rows=99999";
	public SolrSingleton solr = SolrSingleton.getSolrSingleton();
	
	
	/**
	 * Expensive call! (don't expose?) [Somewhat fixed in recent iter]
	 * 
	 * @return
	 */
	//TODO Cache in Database?
	
	public OfferingList getAllClasses() {
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
//				System.out.println(of.getLecture());
//				System.out.println(of.getDiscussion());
				li_of.add(of);
			}
		}
		
		OfferingList oListObj = new OfferingList();
		oListObj.setNum(li_of.size());
		oListObj.setOfferingList(li_of);
//		System.out.println(node);
		return oListObj;
	}


	public Offering getOffering(String cid) {
		JsonNode node;
		node = solr.request(uri_base+"%2Btype%3A+offering+%2Bcid%3A"+cid+uri_qsp);
		System.out.println(uri_base+"%2Btype%3A+offering+%2Bcid%3A"+cid+uri_qsp);
		node = node.get("response");
		
		//should only be one offering for a specific cid.
		if(node.get("numFound").getIntValue() == 1)
		{
			ObjectMapper mapper = new ObjectMapper();
			Offering of;
			try {
				of = mapper.readValue(node.get("docs").get(0).toString(), Offering.class);
				return of;
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
		}
		return null;
	}
	
	public ArrayList<String> getSubjCodes(){
		JsonNode node;
		ArrayList<String> subjCodeList = new ArrayList<String>();
		node = solr.request(uri_base+"*%3A*&rows=0&wt=json&facet=true&facet.field=subjcode");
		node = node.get("facet_counts");
		node = node.get("facet_fields");
		node = node.get("subjcode");
		for(int i = 0; i < node.size(); i++)
		{
			if(i%2==0)
			{
				subjCodeList.add(node.get(i).getTextValue());
			}
		}
		return subjCodeList;
	}
	
}
