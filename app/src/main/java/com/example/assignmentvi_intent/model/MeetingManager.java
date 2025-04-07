package com.example.assignmentvi_intent.model;

import java.util.List;

public class MeetingManager {
    private static List<Meeting> meetings;
    public static void addMeeting(Meeting meeting){
        meetings.add(meeting);
    }
    public static List<Meeting> getMeetings(){
        return meetings;
    }
    public static Meeting searchMeeting(String title, String place, String date, String time,String participants){
        for (Meeting meeting : meetings){
            boolean result = (title == null || meeting.getTitle().equalsIgnoreCase(title) &&
                    place == null || meeting.getPlace().equalsIgnoreCase(place) &&
                    date == null || meeting.getDate().equalsIgnoreCase(date) &&
                    time == null || meeting.getTime().equalsIgnoreCase(time) &&
                    participants == null || meeting.getParticipants().contains(participants));
            if (result) return meeting;
        }
        return null;
    }
    public static void updateMeeting(Meeting oldMeeting, Meeting newMeeting){
        for (Meeting meeting : meetings){
            if (meeting == oldMeeting){
                meeting.setTitle(newMeeting.getTitle());
                meeting.setPlace(newMeeting.getPlace());
                meeting.setParticipants(newMeeting.getParticipants());
                meeting.setDate(newMeeting.getDate());
                meeting.setTime(newMeeting.getTime());
            }
        }
    }

}
