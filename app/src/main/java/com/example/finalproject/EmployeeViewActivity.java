package com.example.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
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

        // Initialize the views
        totalExpensesTextView = findViewById(R.id.totalExpensesTextView);
        approvedExpensesTextView = findViewById(R.id.approvedExpensesTextView);
        pendingExpensesTextView = findViewById(R.id.pendingExpensesTextView);
        submitExpenseButton = findViewById(R.id.submitExpenseButton);
        viewSummaryButton = findViewById(R.id.viewSummaryButton);
        recentActivityListView = findViewById(R.id.recentActivityListView);

        // Setting sample text values
        totalExpensesTextView.setText("Total Submitted: $500");
        approvedExpensesTextView.setText("Approved: $300");
        pendingExpensesTextView.setText("Pending: $200");

        // Set listeners for buttons and icons
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

        if (notificationsIcon != null) {
            notificationsIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openNotifications();
                }
            });
        } else {
            Toast.makeText(this, "Notifications icon not found!", Toast.LENGTH_SHORT).show();
        }

        if (userProfileIcon != null) {
            userProfileIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openProfileSettings();
                }
            });
        } else {
            Toast.makeText(this, "Profile icon not found!", Toast.LENGTH_SHORT).show();
        }

        loadRecentActivity();
    }

    private void openSubmitExpenseScreen() {
        // Navigate to SubmitExpenseActivity
        Intent intent = new Intent(EmployeeViewActivity.this, SubmitExpenseActivity.class);
        startActivity(intent);
    }

    private void openViewSummaryScreen() {
        // Navigate to ExpenseSummaryActivity
        Intent intent = new Intent(EmployeeViewActivity.this, ExpenseSummaryActivity.class);
        startActivity(intent);
    }


    private void openNotifications() {
        Toast.makeText(this, "Opening Notifications...", Toast.LENGTH_SHORT).show();
    }

    private void openProfileSettings() {
        Toast.makeText(this, "Opening Profile & Settings...", Toast.LENGTH_SHORT).show();
    }

    private void loadRecentActivity() {
        ArrayList<String> recentActivities = new ArrayList<>();

        // Retrieve saved expense data from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("ExpenseData", MODE_PRIVATE);
        String expenseType = sharedPreferences.getString("expenseType", "No Expense Found");
        String expenseAmount = sharedPreferences.getString("expenseAmount", "0");

        // Add the retrieved expense to the recent activities list
        recentActivities.add("Expense Type: " + expenseType + " - Amount: $" + expenseAmount);

        // You can add more items to the list as needed for more expenses
        recentActivities.add("Travel Expense - $50 - Approved");
        recentActivities.add("Meal Expense - $30 - Pending");
        recentActivities.add("Office Supplies - $120 - Approved");

        AdapterActivity adapter = new AdapterActivity(this, recentActivities);
        recentActivityListView.setAdapter(adapter);
    }
}
