package com.master.expensetracker.repository

import androidx.lifecycle.LiveData
import com.master.expensetracker.dao.ExpenseDao
import com.master.expensetracker.model.Expense

class ExpenseRepository(private val expenseDao: ExpenseDao) {
    
    val allExpenses: LiveData<List<Expense>> = expenseDao.getAllExpenses()
    
    fun getExpensesByType(typeId: Long): LiveData<List<Expense>> {
        return expenseDao.getExpensesByType(typeId)
    }
    
    suspend fun insert(expense: Expense) {
        expenseDao.insert(expense)
    }
    
    suspend fun update(expense: Expense) {
        expenseDao.update(expense)
    }
    
    suspend fun delete(expense: Expense) {
        expenseDao.delete(expense)
    }
    
    suspend fun getTotalByTypeAndDateRange(typeId: Long, startDate: Long, endDate: Long): Double {
        return expenseDao.getTotalByTypeAndDateRange(typeId, startDate, endDate) ?: 0.0
    }
    
    suspend fun getTotalByType(typeId: Long): Double {
        return expenseDao.getTotalByType(typeId) ?: 0.0
    }
}
