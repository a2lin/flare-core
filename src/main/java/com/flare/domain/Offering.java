package com.flare.domain;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Offering {
	private String type;
	private String cid;
	private String id;
	private String subjcode;
	private String courseno;
	private ArrayList<String> lecture;
	private ArrayList<String> discussion;
	private ArrayList<String> seminar;
	private ArrayList<String> lab;
	private ArrayList<String> tutorial;
	private ArrayList<String> other;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public ArrayList<String> getLecture() {
		return lecture;
	}
	public void setLecture(ArrayList<String> lecture) {
		this.lecture = lecture;
	}
	public ArrayList<String> getDiscussion() {
		return discussion;
	}
	public void setDiscussion(ArrayList<String> discussion) {
		this.discussion = discussion;
	}
	public ArrayList<String> getSeminar() {
		return seminar;
	}
	public void setSeminar(ArrayList<String> seminar) {
		this.seminar = seminar;
	}
	public ArrayList<String> getLab() {
		return lab;
	}
	public void setLab(ArrayList<String> lab) {
		this.lab = lab;
	}
	public ArrayList<String> getTutorial() {
		return tutorial;
	}
	public void setTutorial(ArrayList<String> tutorial) {
		this.tutorial = tutorial;
	}
	public ArrayList<String> getOther() {
		return other;
	}
	public void setOther(ArrayList<String> other) {
		this.other = other;
	}
	
	
}
