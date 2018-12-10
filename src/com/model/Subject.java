package com.model;

public class Subject {

	 private String subjectid;
	 private String subjectname;
	public Subject(String subjectid, String subjectname) {
		super();
		this.subjectid = subjectid;
		this.subjectname = subjectname;
	}
	public Subject() {
		super();
	}
	public String getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	 
}
