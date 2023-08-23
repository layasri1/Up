package com.example.up;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class AvailableJobsActivity extends AppCompatActivity {

    private TextView jobDetailsTextView;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_jobs);

        jobDetailsTextView = findViewById(R.id.jobDetailsTextView);

        // Initialize Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference("user_details");

        // Retrieve job details
        retrieveJobDetails();
    }

    private void retrieveJobDetails() {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                StringBuilder allJobDetails = new StringBuilder();

                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    UserDetails userDetails = userSnapshot.getValue(UserDetails.class);

                    // Format the job details for each user
                    String userJobDetails = "User ID: " + userDetails.getUserId() + "\n" +
                            "Days: " + userDetails.getDays() + "\n" +
                            "Start Date: " + userDetails.getStartDate() + "\n" +
                            "Crop Name: " + userDetails.getCropName() + "\n" +
                            "Work Type: " + userDetails.getWorkType() + "\n" +
                            "Requirement: " + userDetails.getRequirement() + "\n" +
                            "Area: " + userDetails.getArea() + "\n" +
                            "Wage: " + userDetails.getWage() + "\n\n";

                    allJobDetails.append(userJobDetails);
                }

                // Display the combined job details using a Toast
                Toast.makeText(AvailableJobsActivity.this, allJobDetails.toString(), Toast.LENGTH_LONG).show();

                // Set the combined job details in the TextView
                jobDetailsTextView.setText(allJobDetails.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle error
            }
        });
    }


}
