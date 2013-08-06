package com.flare.domain;

import java.util.ArrayList;

public class Offering {
	private String id;
	private String subject;
	private String code;
	private ArrayList<String> lectures;
	private ArrayList<String> discussions;
	private ArrayList<String> seminars;
	private ArrayList<String> labs;
	private ArrayList<String> tutorials;
	private ArrayList<String> other;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public ArrayList<String> getLectures() {
		return lectures;
	}
	public void setLectures(ArrayList<String> lectures) {
		this.lectures = lectures;
	}
	public ArrayList<String> getDiscussions() {
		return discussions;
	}
	public void setDiscussions(ArrayList<String> discussions) {
		this.discussions = discussions;
	}
	public ArrayList<String> getSeminars() {
		return seminars;
	}
	public void setSeminars(ArrayList<String> seminars) {
		this.seminars = seminars;
	}
	public ArrayList<String> getLabs() {
		return labs;
	}
	public void setLabs(ArrayList<String> labs) {
		this.labs = labs;
	}
	public ArrayList<String> getTutorials() {
		return tutorials;
	}
	public void setTutorials(ArrayList<String> tutorials) {
		this.tutorials = tutorials;
	}
	public ArrayList<String> getOther() {
		return other;
	}
	public void setOther(ArrayList<String> other) {
		this.other = other;
	}
	

}
