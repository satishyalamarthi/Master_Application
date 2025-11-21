package com.master.expensetracker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.master.expensetracker.R
import com.master.expensetracker.model.ExpenseTypeWithTotal

class ExpenseTypeAdapter(
    private var expenseTypes: List<ExpenseTypeWithTotal>,
    private val onSetGoalClick: (ExpenseTypeWithTotal) -> Unit,
    private val onViewDetailsClick: (ExpenseTypeWithTotal) -> Unit
) : RecyclerView.Adapter<ExpenseTypeAdapter.ExpenseTypeViewHolder>() {

    class ExpenseTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val typeName: TextView = itemView.findViewById(R.id.expenseTypeName)
        val goalAmount: TextView = itemView.findViewById(R.id.goalAmount)
        val actualAmount: TextView = itemView.findViewById(R.id.actualAmount)
        val setGoalButton: Button = itemView.findViewById(R.id.setGoalButton)
        val viewDetailsButton: Button = itemView.findViewById(R.id.viewDetailsButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseTypeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_expense_type, parent, false)
        return ExpenseTypeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseTypeViewHolder, position: Int) {
        val expenseTypeWithTotal = expenseTypes[position]
        val expenseType = expenseTypeWithTotal.expenseType
        
        holder.typeName.text = expenseType.name
        holder.goalAmount.text = "$${String.format("%.2f", expenseType.monthlyGoal)}"
        holder.actualAmount.text = "$${String.format("%.2f", expenseTypeWithTotal.totalSpent)}"
        
        holder.setGoalButton.setOnClickListener {
            onSetGoalClick(expenseTypeWithTotal)
        }
        
        holder.viewDetailsButton.setOnClickListener {
            onViewDetailsClick(expenseTypeWithTotal)
        }
    }

    override fun getItemCount(): Int = expenseTypes.size

    fun updateData(newExpenseTypes: List<ExpenseTypeWithTotal>) {
        expenseTypes = newExpenseTypes
        notifyDataSetChanged()
    }
}
