package com.example.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AdminDashboardActivity extends AppCompatActivity {

    // Declare UI components
    private TextView overviewTitle, totalSpending, remainingBudget, expenseApprovalTitle, pendingApprovalList, chartTitle, recentActivityTitle, recentActivityList;
    private Button btnAddExpense, btnViewReports, btnManageBudgets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view);

        btnAddExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Placeholder code for Add Expense button click
                totalSpending.setText("Add Expense Clicked");
            }
        });

        btnViewReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Placeholder code for View Reports button click
                remainingBudget.setText("View Reports Clicked");
            }
        });

        btnManageBudgets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Placeholder code for Manage Budgets button click
                pendingApprovalList.setText("Manage Budgets Clicked");
            }
        });
    }
}

