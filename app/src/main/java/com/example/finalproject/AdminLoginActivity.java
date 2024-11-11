package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AdminLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login); // Make sure this XML file exists

        Button btnAdminLogin = findViewById(R.id.btnAdminLogin);

        // Example login action for Admin
        btnAdminLogin.setOnClickListener(v -> {
            // Implement login logic here (replace with actual authentication if needed)
            boolean isLoginSuccessful = true; // Placeholder for login validation

            if (isLoginSuccessful) {
                // Show a success message
                Toast.makeText(AdminLoginActivity.this, "Admin Login Successful", Toast.LENGTH_SHORT).show();

                // Navigate to AdminDashboardActivity
                Intent intent = new Intent(AdminLoginActivity.this, AdminDashboardActivity.class);
                startActivity(intent);
                finish(); // Optional: Close the login screen to prevent going back
            } else {
                // Show an error message for failed login
                Toast.makeText(AdminLoginActivity.this, "Invalid login credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
