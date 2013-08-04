package com.flare.domain;

import java.util.ArrayList;

public class Course {
	private int id;
	private String subject;
	private String code;
	private String professor;
	private ArrayList<String> subList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
	public void setSublist(ArrayList<String> str)
	{
		this.subList = str;
	}
	
	public ArrayList<String> getSublist()
	{
		return subList;
	}

	@Override
	public String toString() {
		return "Class [classId=" + id + ", subject="
				+ code + ", professor=" + professor+"]";
	}

}
