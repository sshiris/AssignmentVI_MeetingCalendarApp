package com.example.assignmentvi_intent.model;

import java.util.List;

public class Meeting {
    private String title;
    private String place;
    private List<String> participants;
    private String date;
    private String time;

    public Meeting(String title, String place, List<String> participants, String date, String time){
        this.title = title;
        this.place = place;
        this.participants = participants;
        this.date = date;
        this.time = time;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setPlace(String place){
        this.place = place;
    }
    public void setParticipants(List<String> participants){
        this.participants = participants;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setTime(String time) {
        this.time = time;;
    }

    public String getTitle(){
        return title;
    }
    public String getPlace(){
        return place;
    }
    public List<String> getParticipants(){
        return participants;
    }
    public String getDate(){
        return date;
    }
    public String getTime(){
        return time;
    }
}
