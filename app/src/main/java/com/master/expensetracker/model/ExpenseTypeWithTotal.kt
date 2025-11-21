package com.master.expensetracker.model

data class ExpenseTypeWithTotal(
    val expenseType: ExpenseType,
    val totalSpent: Double
)
