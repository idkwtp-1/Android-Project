package com.example.finalproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

public class EmployeeLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);

        Button btnEmployeeLogin = findViewById(R.id.btnEmployeeLogin);

        // Example login action for Employee
        btnEmployeeLogin.setOnClickListener(v -> {
            // Implement login logic here
            Toast.makeText(EmployeeLoginActivity.this, "Employee Login Successful", Toast.LENGTH_SHORT).show();
            // Navigate to employee-specific functionality screen if needed
        });
    }
}
