package com.example.up;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailsActivity extends AppCompatActivity {

    private EditText daysEditText, startDateEditText, cropNameEditText, workTypeEditText, requirementEditText, areaEditText, wageEditText;
    private Button submitButton;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Initialize Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference("user_details");

        daysEditText = findViewById(R.id.daysEditText);
        startDateEditText = findViewById(R.id.startDateEditText);
        cropNameEditText = findViewById(R.id.cropNameEditText);
        workTypeEditText = findViewById(R.id.workTypeEditText);
        requirementEditText = findViewById(R.id.requirementEditText);
        areaEditText = findViewById(R.id.areaEditText);
        wageEditText = findViewById(R.id.wageEditText);

        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadDetails();
            }
        });
    }

    private void uploadDetails() {
        String days = daysEditText.getText().toString();
        String startDate = startDateEditText.getText().toString();
        String cropName = cropNameEditText.getText().toString();
        String workType = workTypeEditText.getText().toString();
        String requirement = requirementEditText.getText().toString();
        String area = areaEditText.getText().toString();
        String wage = wageEditText.getText().toString();

        String userId = databaseReference.push().getKey();
       // Toast.makeText(this, days, Toast.LENGTH_SHORT).show();
        UserDetails userDetails = new UserDetails(userId, days, startDate, cropName, workType, requirement, area, wage);

        databaseReference.child(userId).setValue(userDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    // Data uploaded successfully
                    // Open the new activity to display the uploaded data
                    openDisplayDataActivity(days, startDate, cropName, workType, requirement, area, wage);
                } else {
                    // Handle data upload failure
                    displayMessage("Details uploaded unsuccessful!");
                }
            }
        });
    }
    private void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    private void openDisplayDataActivity(String days, String startDate, String cropName, String workType, String requirement, String area, String wage) {
        Intent intent = new Intent(DetailsActivity.this, DisplayDataActivity.class);
        intent.putExtra("days", days);
        intent.putExtra("startDate", startDate);
        intent.putExtra("cropName", cropName);
        intent.putExtra("workType", workType);
        intent.putExtra("requirement", requirement);
        intent.putExtra("area", area);
        intent.putExtra("wage", wage);
        startActivity(intent);
    }
}
