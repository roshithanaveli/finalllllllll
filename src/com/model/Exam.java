package com.model;

import java.sql.Date;

public class Exam
{
	
	String subjectid;
	java.sql.Date date;
	int score;
	String traineeid;
	public Exam(String subjectid, Date date, int score, String traineeid) {
		super();
		this.subjectid = subjectid;
		this.date = date;
		this.score = score;
		this.traineeid = traineeid;
	}
	public Exam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getTraineeid() {
		return traineeid;
	}
	public void setTraineeid(String traineeid) {
		this.traineeid = traineeid;
	}
	
}
