package com.example.assignmentvi_intent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignmentvi_intent.model.Meeting;
import com.example.assignmentvi_intent.model.MeetingManager;

import java.util.List;

public class SummaryActivity extends AppCompatActivity {
    TextView summaryText;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        summaryText = findViewById(R.id.summaryText);

        StringBuilder summaryBuilder = new StringBuilder();
        List<Meeting> meetings = MeetingManager.getMeetings();
        for (Meeting meeting : meetings){
            summaryBuilder.append("Title: ").append(meeting.getTitle()).append("\n")
                    .append("Place: ").append(meeting.getPlace()).append("\n")
                    .append("Participants: ").append(meeting.getParticipants()).append("\n")
                    .append("Date: ").append(meeting.getDate()).append("\n")
                    .append("Time: ").append(meeting.getTime()).append("\n\n");
        }
        summaryText.setText(summaryBuilder);
    }
}
