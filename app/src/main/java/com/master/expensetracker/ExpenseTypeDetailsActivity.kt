package com.master.expensetracker

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.master.expensetracker.adapter.ExpenseAdapter
import com.master.expensetracker.viewmodel.ExpenseTypeViewModel
import com.master.expensetracker.viewmodel.ExpenseViewModel
import kotlinx.coroutines.launch

class ExpenseTypeDetailsActivity : AppCompatActivity() {
    
    private lateinit var expenseTypeViewModel: ExpenseTypeViewModel
    private lateinit var expenseViewModel: ExpenseViewModel
    private lateinit var expenseTypeNameTextView: TextView
    private lateinit var goalAmountTextView: TextView
    private lateinit var totalAmountTextView: TextView
    private lateinit var expensesRecyclerView: RecyclerView
    private lateinit var emptyTextView: TextView
    private lateinit var adapter: ExpenseAdapter
    
    private var expenseTypeId: Long = -1
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expense_type_details)
        
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.expense_details)
        
        expenseTypeViewModel = ViewModelProvider(this)[ExpenseTypeViewModel::class.java]
        expenseViewModel = ViewModelProvider(this)[ExpenseViewModel::class.java]
        
        expenseTypeNameTextView = findViewById(R.id.expenseTypeNameTextView)
        goalAmountTextView = findViewById(R.id.goalAmountTextView)
        totalAmountTextView = findViewById(R.id.totalAmountTextView)
        expensesRecyclerView = findViewById(R.id.expensesRecyclerView)
        emptyTextView = findViewById(R.id.emptyTextView)
        
        // Get data from intent
        expenseTypeId = intent.getLongExtra("EXPENSE_TYPE_ID", -1)
        val expenseTypeName = intent.getStringExtra("EXPENSE_TYPE_NAME") ?: ""
        
        expenseTypeNameTextView.text = expenseTypeName
        
        // Setup RecyclerView
        adapter = ExpenseAdapter(emptyList())
        expensesRecyclerView.adapter = adapter
        expensesRecyclerView.layoutManager = LinearLayoutManager(this)
        
        // Load expense type details
        lifecycleScope.launch {
            val expenseType = expenseTypeViewModel.getExpenseTypeById(expenseTypeId)
            expenseType?.let {
                goalAmountTextView.text = "$${String.format("%.2f", it.monthlyGoal)}"
            }
            
            val total = expenseViewModel.getTotalByType(expenseTypeId)
            totalAmountTextView.text = "$${String.format("%.2f", total)}"
        }
        
        // Observe expenses
        expenseViewModel.getExpensesByType(expenseTypeId).observe(this) { expenses ->
            if (expenses.isEmpty()) {
                expensesRecyclerView.visibility = View.GONE
                emptyTextView.visibility = View.VISIBLE
            } else {
                expensesRecyclerView.visibility = View.VISIBLE
                emptyTextView.visibility = View.GONE
            }
            
            adapter.updateData(expenses)
        }
    }
    
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
