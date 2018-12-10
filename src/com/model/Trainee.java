package com.model;

public class Trainee {

              private String userid;
              private String traineename;
              private String technology;
              private String location;
              private String trainername;
              private String contact;
              private String domain;
              private String education;
              private Integer passoutyear;
              public Trainee() {
                     super();
              }
			public Trainee(String userid, String traineename,
					String technology, String location, String trainername,
					String contact, String domain, String education,
					Integer passoutyear) {
				super();
				this.userid = userid;
				this.traineename = traineename;
				this.technology = technology;
				this.location = location;
				this.trainername = trainername;
				this.contact = contact;
				this.domain = domain;
				this.education = education;
				this.passoutyear = passoutyear;
			}
			public String getUserid() {
				return userid;
			}
			public void setUserid(String userid) {
				this.userid = userid;
			}
			public String getTraineename() {
				return traineename;
			}
			public void setTraineename(String traineename) {
				this.traineename = traineename;
			}
			public String getTechnology() {
				return technology;
			}
			public void setTechnology(String technology) {
				this.technology = technology;
			}
			public String getLocation() {
				return location;
			}
			public void setLocation(String location) {
				this.location = location;
			}
			public String getTrainername() {
				return trainername;
			}
			public void setTrainername(String trainername) {
				this.trainername = trainername;
			}
			public String getContact() {
				return contact;
			}
			public void setContact(String contact) {
				this.contact = contact;
			}
			public String getDomain() {
				return domain;
			}
			public void setDomain(String domain) {
				this.domain = domain;
			}
			public String getEducation() {
				return education;
			}
			public void setEducation(String education) {
				this.education = education;
			}
			public Integer getPassoutyear() {
				return passoutyear;
			}
			public void setPassoutyear(Integer passoutyear) {
				this.passoutyear = passoutyear;
			}
              
}