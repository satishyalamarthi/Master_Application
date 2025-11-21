package com.master.expensetracker.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense_types")
data class ExpenseType(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val monthlyGoal: Double = 0.0
)
