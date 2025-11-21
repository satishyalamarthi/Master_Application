package com.master.expensetracker

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.master.expensetracker.adapter.ExpenseTypeAdapter
import com.master.expensetracker.model.ExpenseTypeWithTotal
import com.master.expensetracker.viewmodel.ExpenseTypeViewModel
import com.master.expensetracker.viewmodel.ExpenseViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    
    private lateinit var expenseTypeViewModel: ExpenseTypeViewModel
    private lateinit var expenseViewModel: ExpenseViewModel
    private lateinit var adapter: ExpenseTypeAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyTextView: TextView
    private lateinit var addExpenseTypeButton: Button
    private lateinit var addExpenseButton: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Initialize ViewModels
        expenseTypeViewModel = ViewModelProvider(this)[ExpenseTypeViewModel::class.java]
        expenseViewModel = ViewModelProvider(this)[ExpenseViewModel::class.java]
        
        // Initialize views
        recyclerView = findViewById(R.id.expenseTypesRecyclerView)
        emptyTextView = findViewById(R.id.emptyTextView)
        addExpenseTypeButton = findViewById(R.id.addExpenseTypeButton)
        addExpenseButton = findViewById(R.id.addExpenseButton)
        
        // Setup RecyclerView
        adapter = ExpenseTypeAdapter(
            emptyList(),
            onSetGoalClick = { expenseTypeWithTotal ->
                val intent = Intent(this, SetGoalActivity::class.java)
                intent.putExtra("EXPENSE_TYPE_ID", expenseTypeWithTotal.expenseType.id)
                intent.putExtra("EXPENSE_TYPE_NAME", expenseTypeWithTotal.expenseType.name)
                intent.putExtra("CURRENT_GOAL", expenseTypeWithTotal.expenseType.monthlyGoal)
                startActivity(intent)
            },
            onViewDetailsClick = { expenseTypeWithTotal ->
                val intent = Intent(this, ExpenseTypeDetailsActivity::class.java)
                intent.putExtra("EXPENSE_TYPE_ID", expenseTypeWithTotal.expenseType.id)
                intent.putExtra("EXPENSE_TYPE_NAME", expenseTypeWithTotal.expenseType.name)
                startActivity(intent)
            }
        )
        
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        
        // Observe expense types
        expenseTypeViewModel.allExpenseTypes.observe(this) { expenseTypes ->
            lifecycleScope.launch {
                val expenseTypesWithTotal = expenseTypes.map { expenseType ->
                    val total = expenseViewModel.getTotalByType(expenseType.id)
                    ExpenseTypeWithTotal(expenseType, total)
                }
                
                if (expenseTypesWithTotal.isEmpty()) {
                    recyclerView.visibility = View.GONE
                    emptyTextView.visibility = View.VISIBLE
                } else {
                    recyclerView.visibility = View.VISIBLE
                    emptyTextView.visibility = View.GONE
                }
                
                adapter.updateData(expenseTypesWithTotal)
            }
        }
        
        // Button click listeners
        addExpenseTypeButton.setOnClickListener {
            val intent = Intent(this, AddExpenseTypeActivity::class.java)
            startActivity(intent)
        }
        
        addExpenseButton.setOnClickListener {
            val intent = Intent(this, AddExpenseActivity::class.java)
            startActivity(intent)
        }
    }
}
