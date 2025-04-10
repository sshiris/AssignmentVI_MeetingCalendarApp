package com.example.assignmentvi_intent.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MeetingManager {
    private static List<Meeting> meetings = new ArrayList<>();
    public static void addMeeting(Meeting meeting){
        meetings.add(meeting);
    }
    public static List<Meeting> getMeetings(){
        if (meetings == null){
            meetings = new ArrayList<>();
        }
        return meetings;
    }
    public static List<Meeting> searchMeeting(String title, String place, String date, String time, List<String> participants) {
        List<Meeting> results = new ArrayList<>();

        for (Meeting meeting : meetings) {
            boolean titleMatch = title.isEmpty() || meeting.getTitle().trim().equalsIgnoreCase(title.trim());
            boolean placeMatch = place.isEmpty() || meeting.getPlace().trim().equalsIgnoreCase(place.trim());
            boolean dateMatch = date.isEmpty() || meeting.getDate().trim().equalsIgnoreCase(date.trim());
            boolean timeMatch = time.isEmpty() || meeting.getTime().trim().equalsIgnoreCase(time.trim());

            boolean participantsMatch;
            if (participants.isEmpty()) {
                participantsMatch = true;
            } else {
                List<String> meetingParticipantsLower = new ArrayList<>();
                for (String p : meeting.getParticipants()) {
                    meetingParticipantsLower.add(p.toLowerCase().trim());
                }

                participantsMatch = false;
                for (String p : participants) {
                    if (meetingParticipantsLower.contains(p.toLowerCase().trim())) {
                        participantsMatch = true;
                        break;
                    }
                }
            }

            if (titleMatch && placeMatch && dateMatch && timeMatch && participantsMatch) {
                results.add(meeting);
            }
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
