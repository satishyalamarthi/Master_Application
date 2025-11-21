package com.master.expensetracker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.master.expensetracker.R
import com.master.expensetracker.model.Expense
import java.text.SimpleDateFormat
import java.util.*

class ExpenseAdapter(
    private var expenses: List<Expense>
) : RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {

    class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val amount: TextView = itemView.findViewById(R.id.expenseAmount)
        val date: TextView = itemView.findViewById(R.id.expenseDate)
        val description: TextView = itemView.findViewById(R.id.expenseDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_expense, parent, false)
        return ExpenseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val expense = expenses[position]
        
        holder.amount.text = "$${String.format("%.2f", expense.amount)}"
        holder.description.text = expense.description
        
        val dateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        holder.date.text = dateFormat.format(Date(expense.date))
    }

    override fun getItemCount(): Int = expenses.size

    fun updateData(newExpenses: List<Expense>) {
        expenses = newExpenses
        notifyDataSetChanged()
    }
}
