package com.model;

import java.sql.Date;
import java.util.*;

public class Question {

	private String questionid;
	private String questiondescription;
	private String questiontype;
	private String subjectid;
	private  java.sql.Date date;
	private String trainerid;
	private List<Answer> AnswerList;
	public String getQuestionid() {
		return questionid;
	}
	
	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}
	public String getQuestiondescription() {
		return questiondescription;
	}
	public void setQuestiondescription(String questiondescription) {
		this.questiondescription = questiondescription;
	}
	public String getQuestiontype() {
		return questiontype;
	}
	public void setQuestiontype(String questiontype) {
		this.questiontype = questiontype;
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
	public String getTrainerid() {
		return trainerid;
	}
	public void setTrainerid(String trainerid) {
		this.trainerid = trainerid;
	}
	public Question() {
		super();
	}

	public Question(String questionid, String questiondescription,
			String questiontype, String subjectid, Date date, String trainerid,
			List<Answer> answerList) {
		super();
		this.questionid = questionid;
		this.questiondescription = questiondescription;
		this.questiontype = questiontype;
		this.subjectid = subjectid;
		this.date = date;
		this.trainerid = trainerid;
		AnswerList = answerList;
	}

	public List<Answer> getAnswerList() {
		return AnswerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		AnswerList = answerList;
	}

	public Question(String questionid, String questiondescription,
			String questiontype, String subjectid, Date date, String trainerid) {
		super();
		this.questionid = questionid;
		this.questiondescription = questiondescription;
		this.questiontype = questiontype;
		this.subjectid = subjectid;
		this.date = date;
		this.trainerid = trainerid;
	}


	
	
	
	
}
