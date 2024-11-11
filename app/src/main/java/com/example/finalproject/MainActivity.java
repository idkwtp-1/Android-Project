package com.example.finalproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge mode
        EdgeToEdge.enable(this);

        // Set the main layout
        setContentView(R.layout.activity_main);

        // Apply window insets to adjust padding for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find buttons and set up click listeners
        Button btnAdmin = findViewById(R.id.btnAdmin);
        Button btnEmployee = findViewById(R.id.btnEmployee);

        btnAdmin.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AdminLoginActivity.class);
            startActivity(intent);
        });

        btnEmployee.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EmployeeLoginActivity.class);
            startActivity(intent);
        });
    }
}
