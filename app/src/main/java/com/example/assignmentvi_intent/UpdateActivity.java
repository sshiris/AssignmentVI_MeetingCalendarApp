package com.example.assignmentvi_intent;

import android.annotation.SuppressLint;
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

public class UpdateActivity extends AppCompatActivity {
    EditText searchTitle, searchPlace, searchParticipant, searchDate, searchTime;
    EditText editTitle, editPlace, editParticipant,editDate, editTime;
    TextView showMeeting;
    Button btnFound, btnSaveChanges;

    List<Meeting> foundMeetings;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        searchTitle = findViewById(R.id.search_title_update);
        searchPlace = findViewById(R.id.search_place_update);
        searchParticipant = findViewById(R.id.search_participants_update);
        searchDate = findViewById(R.id.search_date_update);
        searchTime = findViewById(R.id.search_time_update);
        btnFound = findViewById(R.id.btn_searchToUpdate);

        showMeeting = findViewById(R.id.show_meeting_to_update);


        editTitle = findViewById(R.id.editTitle);
        editPlace = findViewById(R.id.editPlace);
        editParticipant = findViewById(R.id.editParticipants);
        editDate = findViewById(R.id.editDate);
        editTime = findViewById(R.id.editTime);
        btnSaveChanges = findViewById(R.id.saveChanges);


        btnFound.setOnClickListener(v -> {
            showMeeting.setText("");
            String title = searchTitle.getText().toString();
            String place = searchPlace.getText().toString();
            List<String> participantsArray = Arrays.asList(searchParticipant.getText().toString().split(","));
            List<String> participants = new ArrayList<>(participantsArray);
            String date = searchDate.getText().toString();
            String time = searchTime.getText().toString();

            if (title.isEmpty() && place.isEmpty() && participants.isEmpty() && date.isEmpty() && time.isEmpty()){
                Toast.makeText(this, "Please enter at least one search criteria.", Toast.LENGTH_SHORT).show();
                return;
            }

            foundMeetings = MeetingManager.searchMeeting(title, place, date, time, participants);

            if (!foundMeetings.isEmpty()) {

                    showMeeting.setText("Title: " + foundMeetings.get(0).getTitle() + "\n"
                            + "Place: " + foundMeetings.get(0).getPlace() + "\n"
                            + "Participants: " + foundMeetings.get(0).getParticipants() + "\n"
                            + "Date: " + foundMeetings.get(0).getDate() + "\n");


            }
        });

        btnSaveChanges.setOnClickListener(v->{
            String newTitle = editTitle.getText().toString();
            String newPlace = editPlace.getText().toString();
            List<String> newParticipantsArray = Arrays.asList(editParticipant.getText().toString().split(","));
            List<String> newParticipants = new ArrayList<>(newParticipantsArray);
            String newDate = editDate.getText().toString();
            String newTime = editTime.getText().toString();

            if(!foundMeetings.isEmpty()) {
                Meeting newMeeting = new Meeting(newTitle, newPlace, newParticipants, newDate, newTime);
                MeetingManager.updateMeeting(foundMeetings.get(0), newMeeting);

                Toast.makeText(this, "Meeting updated successfully.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
