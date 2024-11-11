package com.example.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class EmployeeViewActivity extends AppCompatActivity {

    private TextView totalExpensesTextView, approvedExpensesTextView, pendingExpensesTextView;
    private Button submitExpenseButton, viewSummaryButton;
    private ImageView notificationsIcon, userProfileIcon;
    private ListView recentActivityListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_view);

        totalExpensesTextView = findViewById(R.id.totalExpensesTextView);
        approvedExpensesTextView = findViewById(R.id.approvedExpensesTextView);
        pendingExpensesTextView = findViewById(R.id.pendingExpensesTextView);
        submitExpenseButton = findViewById(R.id.submitExpenseButton);
        viewSummaryButton = findViewById(R.id.viewSummaryButton);
        recentActivityListView = findViewById(R.id.recentActivityListView);

        totalExpensesTextView.setText("Total Submitted: $500");
        approvedExpensesTextView.setText("Approved: $300");
        pendingExpensesTextView.setText("Pending: $200");

        submitExpenseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSubmitExpenseScreen();
            }
        });

        viewSummaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewSummaryScreen();
            }
        });

        notificationsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNotifications();
            }
        });

        userProfileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfileSettings();
            }
        });

        loadRecentActivity();
    }

    private void openSubmitExpenseScreen() {
        Toast.makeText(this, "Opening Submit Expense Screen...", Toast.LENGTH_SHORT).show();
    }

    private void openViewSummaryScreen() {
        Toast.makeText(this, "Opening View Summary Screen...", Toast.LENGTH_SHORT).show();
    }

    private void openNotifications() {
        Toast.makeText(this, "Opening Notifications...", Toast.LENGTH_SHORT).show();
    }

    private void openProfileSettings() {
        Toast.makeText(this, "Opening Profile & Settings...", Toast.LENGTH_SHORT).show();
    }

    private void loadRecentActivity() {
        ArrayList<String> recentActivities = new ArrayList<>();
        recentActivities.add("Travel Expense - $50 - Approved");
        recentActivities.add("Meal Expense - $30 - Pending");
        recentActivities.add("Office Supplies - $120 - Approved");

        AdapterActivity adapter = new AdapterActivity(this, recentActivities);
        recentActivityListView.setAdapter(adapter);
    }
}
