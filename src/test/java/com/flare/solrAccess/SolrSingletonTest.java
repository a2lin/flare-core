package com.flare.solrAccess;

import junit.framework.TestCase;

import org.codehaus.jackson.JsonNode;

public class SolrSingletonTest extends TestCase{
	public SolrSingleton ss = SolrSingleton.getSolrSingleton();
	
	public void testRequest()
	{
		JsonNode jN = ss.request("http://localhost:8983/solr/collection1/select?q=*%3A*&wt=json&indent=true");
		System.out.println(jN.toString());
	}
}
