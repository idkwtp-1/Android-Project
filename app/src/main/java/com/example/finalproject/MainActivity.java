package com.example.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnAdmin, btnEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the buttons by their IDs
        btnAdmin = findViewById(R.id.btnAdmin);
        btnEmployee = findViewById(R.id.btnEmployee);

        // Set onClick listeners for buttons
        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Admin Login Activity
                Intent intent = new Intent(MainActivity.this, AdminLoginActivity.class);
                startActivity(intent);
            }
        });

        btnEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Employee Login Activity
                Intent intent = new Intent(MainActivity.this, EmployeeLoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
