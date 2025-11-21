package com.master.expensetracker

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.master.expensetracker.model.Expense
import com.master.expensetracker.model.ExpenseType
import com.master.expensetracker.viewmodel.ExpenseTypeViewModel
import com.master.expensetracker.viewmodel.ExpenseViewModel

class AddExpenseActivity : AppCompatActivity() {
    
    private lateinit var expenseTypeViewModel: ExpenseTypeViewModel
    private lateinit var expenseViewModel: ExpenseViewModel
    private lateinit var expenseTypeSpinner: Spinner
    private lateinit var amountEditText: TextInputEditText
    private lateinit var descriptionEditText: TextInputEditText
    private lateinit var saveExpenseButton: Button
    
    private var expenseTypes = listOf<ExpenseType>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)
        
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.add_expense)
        
        expenseTypeViewModel = ViewModelProvider(this)[ExpenseTypeViewModel::class.java]
        expenseViewModel = ViewModelProvider(this)[ExpenseViewModel::class.java]
        
        expenseTypeSpinner = findViewById(R.id.expenseTypeSpinner)
        amountEditText = findViewById(R.id.amountEditText)
        descriptionEditText = findViewById(R.id.descriptionEditText)
        saveExpenseButton = findViewById(R.id.saveExpenseButton)
        
        // Observe expense types
        expenseTypeViewModel.allExpenseTypes.observe(this) { types ->
            expenseTypes = types
            
            if (types.isEmpty()) {
                Toast.makeText(this, R.string.no_expense_types, Toast.LENGTH_LONG).show()
                finish()
                return@observe
            }
            
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                types.map { it.name }
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            expenseTypeSpinner.adapter = adapter
        }
        
        saveExpenseButton.setOnClickListener {
            saveExpense()
        }
    }
    
    private fun saveExpense() {
        val amountStr = amountEditText.text.toString().trim()
        val description = descriptionEditText.text.toString().trim()
        
        if (amountStr.isEmpty()) {
            Toast.makeText(this, R.string.error_empty_amount, Toast.LENGTH_SHORT).show()
            return
        }
        
        val amount = amountStr.toDoubleOrNull()
        if (amount == null || amount <= 0) {
            Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_SHORT).show()
            return
        }
        
        if (expenseTypes.isEmpty()) {
            Toast.makeText(this, R.string.error_select_type, Toast.LENGTH_SHORT).show()
            return
        }
        
        val selectedPosition = expenseTypeSpinner.selectedItemPosition
        val selectedExpenseType = expenseTypes[selectedPosition]
        
        val expense = Expense(
            typeId = selectedExpenseType.id,
            amount = amount,
            description = description
        )
        
        expenseViewModel.insert(expense)
        
        Toast.makeText(this, "Expense saved", Toast.LENGTH_SHORT).show()
        finish()
    }
    
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
