package com.example.assignmentvi_intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignmentvi_intent.model.Meeting;
import com.example.assignmentvi_intent.model.MeetingManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    EditText et_title, et_place, et_participants, et_date, et_time;
    Button btn_submit, btn_summary, btn_search, btn_update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_title = findViewById(R.id.editTitle);
        et_place = findViewById(R.id.editPlace);
        et_participants = findViewById(R.id.editParticipants);
        et_date = findViewById(R.id.editDate);
        et_time = findViewById(R.id.editTime);

        btn_submit = findViewById(R.id.btnSubmit);
        btn_summary = findViewById(R.id.btnSummary);
        btn_search = findViewById(R.id.btnSearch);
        btn_update = findViewById(R.id.btnUpdate);

        btn_submit.setOnClickListener(view -> {
            String title = et_title.getText().toString();
            String place = et_place.getText().toString();

            String participantsText = et_participants.getText().toString();
            List<String> participantsArray = Arrays.asList(participantsText.split(","));
            List<String> participants = new ArrayList<>(participantsArray);

            String date = et_date.getText().toString();
            String time = et_time.getText().toString();

            Meeting meeting = new Meeting(title, place, participants, date, time);
            MeetingManager.addMeeting(meeting);

        });

        btn_summary.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
            startActivity(intent);
        });

        btn_search.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(intent);
        });
        btn_update.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
            startActivity(intent);
        });

    }

}