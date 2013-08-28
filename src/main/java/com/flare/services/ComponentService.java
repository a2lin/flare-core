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

import com.flare.domain.Component;
import com.flare.domain.ComponentList;
import com.flare.solrAccess.SolrSingleton;

@Service
public class ComponentService {
	private static final Logger logger_c = Logger.getLogger(CourseService.class);
	private static final String uri_base = "http://ec2-54-213-31-81.us-west-2.compute.amazonaws.com:8983/solr/collection1/select?q=";
	private static final String uri_qsp = "&wt=json&indent=true&rows=99999";
	public SolrSingleton solr = SolrSingleton.getSolrSingleton();
	
	public Component getComponent(String sectid) {
		JsonNode node;
		Component comp = null;
		node = solr.request(uri_base+"%2Bsectid%3A"+sectid+"+%2Btype%3Acomponent"+uri_qsp);
		node = node.get("response");
		if(node.get("numFound").getIntValue() > 0)
		{
			node = node.get("docs");
			ObjectMapper mapper = new ObjectMapper();
			try {
				comp = mapper.readValue(node.get(0).toString(), Component.class);
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
		return comp;

	}

	
	public ComponentList getAllComponents() {
		JsonNode node;
		ArrayList<Component> compList = new ArrayList<Component>();
		node = solr.request(uri_base+"%2Btype%3Acomponent" + uri_qsp);
		node = node.get("response");
		if(node.get("numFound").getIntValue() > 0)
		{
			Component comp = null;
			node = node.get("docs");
			ObjectMapper mapper = new ObjectMapper();
			for(int i = 0; i < node.size(); i++)
			{
				try {
					comp = mapper.readValue(node.get(i).toString(), Component.class);
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
				compList.add(comp);
			}
		}
		
		ComponentList cListObj = new ComponentList();
		cListObj.setComponents(compList);
		cListObj.setNum(compList.size());
		
		return cListObj;
	}

}
