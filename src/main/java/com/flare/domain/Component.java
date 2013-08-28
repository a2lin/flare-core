package com.flare.domain;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Component {
	private String id;
	private String cid;
	private String type;
	private String quarter;
	private String year;
	private String subjcode;
	private String courseno;
	private int sectid;
	private String doctype;
	private String sectcode;
	private String days;
	private int classhr_start;
	private int classhr_end;
	private String location;
	private String room;
	private String professor;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSubjcode() {
		return subjcode;
	}
	public void setSubjcode(String subjcode) {
		this.subjcode = subjcode;
	}
	public String getCourseno() {
		return courseno;
	}
	public void setCourseno(String courseno) {
		this.courseno = courseno;
	}
	public int getSectid() {
		return sectid;
	}
	public void setSectid(int sectid) {
		this.sectid = sectid;
	}
	public String getDoctype() {
		return doctype;
	}
	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}
	public String getSectcode() {
		return sectcode;
	}
	public void setSectcode(String sectcode) {
		this.sectcode = sectcode;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public int getClasshr_start() {
		return classhr_start;
	}
	public void setClasshr_start(int classhr_start) {
		this.classhr_start = classhr_start;
	}
	public int getClasshr_end() {
		return classhr_end;
	}
	public void setClasshr_end(int classhr_end) {
		this.classhr_end = classhr_end;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
	
}
