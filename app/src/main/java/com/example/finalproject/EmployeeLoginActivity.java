package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EmployeeLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);

        // Find the login button by its ID
        Button btnEmployeeLogin = findViewById(R.id.btnEmployeeLogin);

        // Set up the click listener for the login button
        btnEmployeeLogin.setOnClickListener(v -> {
            // Simulate a login process (replace this with actual authentication logic)
            boolean isLoginSuccessful = true;

            if (isLoginSuccessful) {
                // If login is successful, show a success message
                Toast.makeText(EmployeeLoginActivity.this, "Employee Login Successful", Toast.LENGTH_SHORT).show();

                // Navigate to EmployeeViewActivity
                Intent intent = new Intent(EmployeeLoginActivity.this, EmployeeViewActivity.class);
                startActivity(intent);

                // Finish the current activity to prevent going back to the login screen
                finish();
            } else {
                // If login fails, show an error message
                Toast.makeText(EmployeeLoginActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
