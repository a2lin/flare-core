package com.flare.solrAccess;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class SolrSingleton {
	private static SolrSingleton s_sin = null;
	private SolrSingleton()
	{
		
	}
	public static SolrSingleton getSolrSingleton()
	{
		if(s_sin == null)
		{
			s_sin = new SolrSingleton();
		}
		return s_sin;
	}
	
	public JsonNode request(String uri)
	{
//		HttpClient httpclient = HttpClientBuilder.create().build();
//		HttpGet httpGet = new HttpGet("http://targethost/homepage");
		
		JsonNode result = null;
		URL requestUrl = null;
		try {
			requestUrl = new URL(uri);
		} catch (MalformedURLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			return null;
		}
		
		URLConnection con;
		try {
			con = requestUrl.openConnection();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
			
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode root = mapper.readValue(con.getInputStream(), JsonNode.class);
			result = root;
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return result;
	}
	
}
