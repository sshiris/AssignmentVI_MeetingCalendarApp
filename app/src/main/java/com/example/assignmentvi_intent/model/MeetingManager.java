package com.example.assignmentvi_intent.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MeetingManager {
    private static List<Meeting> meetings;
    public static void addMeeting(Meeting meeting){
        meetings.add(meeting);
    }
    public static List<Meeting> getMeetings(){
        return meetings;
    }
    public static List<Meeting> searchMeeting(String title, String place, String date, String time, List<String> participants){
        List<Meeting> results = new ArrayList<>();
        for (Meeting meeting : meetings){
            boolean result = (title == null || meeting.getTitle().equalsIgnoreCase(title) &&
                    place == null || meeting.getPlace().equalsIgnoreCase(place) &&
                    date == null || meeting.getDate().equalsIgnoreCase(date) &&
                    time == null || meeting.getTime().equalsIgnoreCase(time) &&
                    participants == null || new HashSet<>(meeting.getParticipants()).containsAll(participants));
            if (result) {
                results.add(meeting);
            };
        }
        return results;
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
