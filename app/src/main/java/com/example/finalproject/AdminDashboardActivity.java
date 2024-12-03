package com.example.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList; // Make sure you import necessary classes for lists, etc.

public class AdminDashboardActivity extends AppCompatActivity {

    private ExpenseAdapter adapter; // Declare adapter at class level for access in updateExpenseStatus

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view); // Ensure this is the correct layout

        // Find the views in the layout
        EditText expenseType = findViewById(R.id.expenseType);
        EditText expenseAmount = findViewById(R.id.expenseAmount);
        Button btnSaveExpense = findViewById(R.id.btnSaveExpense);
        Button btnAddExpense = findViewById(R.id.btnAddExpense);
        Button btnViewReports = findViewById(R.id.btn_view_reports);
        Button btnManageBudgets = findViewById(R.id.btn_manage_budgets);
        Button btnExpenseApproval = findViewById(R.id.btn_approve_expenses);

        // Initially hide the input fields and save button
        expenseType.setVisibility(View.GONE);
        expenseAmount.setVisibility(View.GONE);
        btnSaveExpense.setVisibility(View.GONE);

        // Set click listener for the 'Add Expense' button
        btnAddExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the input fields for expense type and amount
                expenseType.setVisibility(View.VISIBLE);
                expenseAmount.setVisibility(View.VISIBLE);
                btnSaveExpense.setVisibility(View.VISIBLE);
            }
        });

        // Set click listener for the 'Save Expense' button
        btnSaveExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expenseTypeStr = expenseType.getText().toString();
                String expenseAmountStr = expenseAmount.getText().toString();

                // Validate inputs
                if (expenseTypeStr.isEmpty() || expenseAmountStr.isEmpty()) {
                    Toast.makeText(AdminDashboardActivity.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Save data to SharedPreferences
                SharedPreferences sharedPreferences = getSharedPreferences("ExpenseData", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("expenseType", expenseTypeStr);
                editor.putString("expenseAmount", expenseAmountStr);
                editor.apply();

                // Log success and show a Toast message
                Log.d("AdminDashboardActivity", "Expense saved successfully!");
                Toast.makeText(AdminDashboardActivity.this, "Expense saved!", Toast.LENGTH_SHORT).show();

                // Optionally, navigate to EmployeeDashboardActivity
                Intent intent = new Intent(AdminDashboardActivity.this, EmployeeViewActivity.class);
                startActivity(intent);
            }
        });

        // Set up RecyclerView and Adapter for displaying expense requests
        RecyclerView recyclerView = findViewById(R.id.rvExpenses);
        ArrayList<ExpenseRequest> expenseRequests = new ArrayList<>(); // You need to initialize this list from your data source
        adapter = new ExpenseAdapter(expenseRequests, new ExpenseAdapter.ExpenseListener() {
            @Override
            public void onAccept(ExpenseRequest expense) {
                updateExpenseStatus(expense, "Accepted");
            }

            @Override
            public void onDecline(ExpenseRequest expense) {
                updateExpenseStatus(expense, "Declined");
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // Method to update the status of an expense request
    public void updateExpenseStatus(ExpenseRequest expense, String status) {
        // Update the status in the backend
        expense.setStatus(status);
        // Notify the adapter to refresh the list
        adapter.notifyDataSetChanged();
        // Optionally, send a notification to the employee about the status update
    }
}
