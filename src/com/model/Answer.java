package com.model;




public class Answer {

	private String answerid;
	private String answerdescription;
	private String questionid;
	
	public String getAnswerid() {
		return answerid;
	}
	public void setAnswerid(String answerid) {
		this.answerid = answerid;
	}
	public String getAnswerdescription() {
		return answerdescription;
	}
	public void setAnswerdescription(String answerdescription) {
		this.answerdescription = answerdescription;
	}
	public String getQuestionid() {
		return questionid;
	}
	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}
	public Answer() {
		super();
	}
	public Answer(String answerid, String answerdescription, String questionid) {
		super();
		this.answerid = answerid;
		this.answerdescription = answerdescription;
		this.questionid = questionid;
	}
	
	
}
