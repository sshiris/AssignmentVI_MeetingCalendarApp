package com.example.assignmentvi_intent;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignmentvi_intent.model.Meeting;
import com.example.assignmentvi_intent.model.MeetingManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    EditText searchTitle, searchPlace, searchParticipant, searchDate, searchTime;
    Button btnSearch;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchTitle = findViewById(R.id.search_title);
        searchPlace = findViewById(R.id.search_place);
        searchParticipant = findViewById(R.id.search_participants);
        searchDate = findViewById(R.id.search_date);
        searchTime = findViewById(R.id.search_time);
        btnSearch = findViewById(R.id.btnSearch);
        resultText = findViewById(R.id.search_result);

        btnSearch.setOnClickListener(v -> {
            String title = searchTitle.getText().toString();
            String place = searchPlace.getText().toString();

            String participantsText = searchParticipant.getText().toString();
            List<String> participantsArray = Arrays.asList(participantsText.split(","));
            List<String> participants = new ArrayList<>();

            for (String p : participantsArray) {
                if (!p.trim().isEmpty()) {
                    participants.add(p.trim());
                }
            }

            String date = searchDate.getText().toString();
            String time = searchTime.getText().toString();

            if (title.isEmpty() && place.isEmpty() && participants.isEmpty() && date.isEmpty() && time.isEmpty()){
                Toast.makeText(this, "Please enter at least one search parameter.", Toast.LENGTH_SHORT).show();
                return;
            }

            List<Meeting> meetings = MeetingManager.searchMeeting(title, place, date, time, participants);

            if (!meetings.isEmpty()){
                StringBuilder resultBuilder = new StringBuilder();
                for (Meeting meeting : meetings){
                    resultBuilder.append("Title: ").append(meeting.getTitle()).append("\n")
                            .append("Place: ").append(meeting.getPlace()).append("\n")
                            .append("Participants: ").append(meeting.getParticipants()).append("\n")
                            .append("Date: ").append(meeting.getDate()).append("\n")
                            .append("Time: ").append(meeting.getTime()).append("\n\n");
                }
                resultText.setText(resultBuilder);
            } else {
                resultText.setText("No meetings found.");
            };

        });
    }

}
