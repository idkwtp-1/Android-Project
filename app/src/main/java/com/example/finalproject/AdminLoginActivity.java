package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminLoginActivity extends AppCompatActivity {

    EditText adminUsername, adminPassword;
    Button btnAdminLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login); // Replace with your actual XML file for login activity

        // Initialize UI elements
        adminUsername = findViewById(R.id.adminUsername);
        adminPassword = findViewById(R.id.adminPassword);
        btnAdminLogin = findViewById(R.id.btnAdminLogin);

        // Set click listener for the login button
        btnAdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input from the username and password fields
                String username = adminUsername.getText().toString();
                String password = adminPassword.getText().toString();

                // Validate credentials
                if (isValidLogin(username, password)) {
                    // Successful login, transition to the Admin Dashboard
                    Intent intent = new Intent(AdminLoginActivity.this, AdminDashboardActivity.class);
                    startActivity(intent);
                    finish(); // Optionally, finish the login activity to prevent going back to it
                } else {
                    // Show error message if login fails
                    Toast.makeText(AdminLoginActivity.this, "Invalid credentials, try again!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to validate login credentials
    private boolean isValidLogin(String username, String password) {
        // Replace with your actual validation logic, e.g., check against stored credentials
        return username.equals("admin") && password.equals("admin123");
    }
}
