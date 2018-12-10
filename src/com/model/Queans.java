package com.model;

public class Queans
{
    
    private String answerid;
    private String questionid;
    public Queans() {
           super();
    }
    
    public Queans( String answerid, String questionid) {
           super();
          
           this.answerid = answerid;
           this.questionid = questionid;
    }


    public String getAnswerid() {
           return answerid;
    }
    public void setAnswerid(String answerid) {
           this.answerid = answerid;
    }

	public String getQuestionid() {
		return questionid;
	}

	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}


    

}
