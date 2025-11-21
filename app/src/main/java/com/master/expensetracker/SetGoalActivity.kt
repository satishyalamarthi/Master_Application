package com.master.expensetracker

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.master.expensetracker.viewmodel.ExpenseTypeViewModel

class SetGoalActivity : AppCompatActivity() {
    
    private lateinit var expenseTypeViewModel: ExpenseTypeViewModel
    private lateinit var expenseTypeNameTextView: TextView
    private lateinit var goalEditText: TextInputEditText
    private lateinit var saveGoalButton: Button
    
    private var expenseTypeId: Long = -1
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_goal)
        
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.set_goal)
        
        expenseTypeViewModel = ViewModelProvider(this)[ExpenseTypeViewModel::class.java]
        
        expenseTypeNameTextView = findViewById(R.id.expenseTypeNameTextView)
        goalEditText = findViewById(R.id.goalEditText)
        saveGoalButton = findViewById(R.id.saveGoalButton)
        
        // Get data from intent
        expenseTypeId = intent.getLongExtra("EXPENSE_TYPE_ID", -1)
        val expenseTypeName = intent.getStringExtra("EXPENSE_TYPE_NAME") ?: ""
        val currentGoal = intent.getDoubleExtra("CURRENT_GOAL", 0.0)
        
        expenseTypeNameTextView.text = "Set Goal for $expenseTypeName"
        
        if (currentGoal > 0) {
            goalEditText.setText(currentGoal.toString())
        }
        
        saveGoalButton.setOnClickListener {
            saveGoal()
        }
    }
    
    private fun saveGoal() {
        val goalStr = goalEditText.text.toString().trim()
        
        if (goalStr.isEmpty()) {
            Toast.makeText(this, "Please enter a goal amount", Toast.LENGTH_SHORT).show()
            return
        }
        
        val goal = goalStr.toDoubleOrNull()
        if (goal == null || goal < 0) {
            Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_SHORT).show()
            return
        }
        
        expenseTypeViewModel.updateMonthlyGoal(expenseTypeId, goal)
        
        Toast.makeText(this, "Goal updated", Toast.LENGTH_SHORT).show()
        finish()
    }
    
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
