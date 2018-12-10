package com.model;

public class Trainer {

    private String userid;
    private String trainername;
    private String technology;
    private String location;
    private String contact;
    private String email;
    public Trainer() {
           super();
    }
    public Trainer(String userid, String trainername, String technology,
                  String location, String contact, String email) {
           super();
           this.userid = userid;
           this.trainername = trainername;
           this.technology = technology;
           this.location = location;
           this.contact = contact;
           this.email = email;
    }
    public String getUserid() {
           return userid;
    }
    public void setUserid(String userid) {
           this.userid = userid;
    }
    public String getTrainername() {
           return trainername;
    }
    public void setTrainername(String trainername) {
           this.trainername = trainername;
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
    public String getContact() {
           return contact;
    }
    public void setContact(String contact) {
           this.contact = contact;
    }
    public String getEmail() {
           return email;
    }
    public void setEmail(String email) {
           this.email = email;
    }
    
}
