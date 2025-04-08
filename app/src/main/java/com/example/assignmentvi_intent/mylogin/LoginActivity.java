package com.example.assignmentvi_intent.mylogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

import com.example.assignmentvi_intent.R;

public class LoginActivity extends AppCompatActivity {
    EditText usernameEditText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        String data = "";
//Here we access the incoming Intenet object
        Bundle extras = getIntent().getExtras();
        if (extras != null)
            data = extras.getString("data");
        usernameEditText = findViewById(R.id.et_username);
//Here we set the hint value of the edit text to the data
//sent by calling activity
        usernameEditText.setHint(data);
        Button submitButton = findViewById(R.id.btn_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
//In the following we prepare intent to be sent back to
//the calling activity.
                                                Intent intent = new Intent();
                                                intent.putExtra("user_name", usernameEditText.getText().toString());
                                                intent.putExtra("current_time", new Date().toString());
//Here we set the intent to pass back
// intent.setData(Uri.parse(usernameEditText.getText().toString()));
                                                setResult(RESULT_OK, intent);
//Here we close the activity
                                                finish();
                                            }
                                        }
        );
    }
}