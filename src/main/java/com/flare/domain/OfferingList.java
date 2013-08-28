package com.flare.domain;

import java.util.List;

import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({"num"})
public class OfferingList {
	private int num;
	private List<Offering> offeringList;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public List<Offering> getOfferingList() {
		return offeringList;
	}
	public void setOfferingList(List<Offering> offeringList) {
		this.offeringList = offeringList;
	}
	
}
