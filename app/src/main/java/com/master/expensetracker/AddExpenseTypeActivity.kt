package com.master.expensetracker

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.master.expensetracker.model.ExpenseType
import com.master.expensetracker.viewmodel.ExpenseTypeViewModel

class AddExpenseTypeActivity : AppCompatActivity() {
    
    private lateinit var expenseTypeViewModel: ExpenseTypeViewModel
    private lateinit var typeNameEditText: TextInputEditText
    private lateinit var saveButton: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense_type)
        
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.add_expense_type)
        
        expenseTypeViewModel = ViewModelProvider(this)[ExpenseTypeViewModel::class.java]
        
        typeNameEditText = findViewById(R.id.typeNameEditText)
        saveButton = findViewById(R.id.saveButton)
        
        saveButton.setOnClickListener {
            saveExpenseType()
        }
    }
    
    private fun saveExpenseType() {
        val name = typeNameEditText.text.toString().trim()
        
        if (name.isEmpty()) {
            Toast.makeText(this, R.string.error_empty_name, Toast.LENGTH_SHORT).show()
            return
        }
        
        val expenseType = ExpenseType(name = name)
        expenseTypeViewModel.insert(expenseType)
        
        Toast.makeText(this, "Expense type saved", Toast.LENGTH_SHORT).show()
        finish()
    }
    
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
