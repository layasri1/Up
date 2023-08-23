package com.example.up;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayDataActivity extends AppCompatActivity {

    private TextView displayDaysTextView;
    // Declare similar TextViews for other data fields

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        displayDaysTextView = findViewById(R.id.displayDaysTextView);
        // Initialize similar TextViews for other data fields

        // Get the uploaded data from the intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String days = extras.getString("days");
            displayDaysTextView.setText("Days: " + days);
            // Set similar text for other data fields
        }
    }
}
