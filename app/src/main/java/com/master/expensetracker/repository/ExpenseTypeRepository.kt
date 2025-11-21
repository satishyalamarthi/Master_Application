package com.master.expensetracker.repository

import androidx.lifecycle.LiveData
import com.master.expensetracker.dao.ExpenseTypeDao
import com.master.expensetracker.model.ExpenseType

class ExpenseTypeRepository(private val expenseTypeDao: ExpenseTypeDao) {
    
    val allExpenseTypes: LiveData<List<ExpenseType>> = expenseTypeDao.getAllExpenseTypes()
    
    suspend fun insert(expenseType: ExpenseType): Long {
        return expenseTypeDao.insert(expenseType)
    }
    
    suspend fun update(expenseType: ExpenseType) {
        expenseTypeDao.update(expenseType)
    }
    
    suspend fun delete(expenseType: ExpenseType) {
        expenseTypeDao.delete(expenseType)
    }
    
    suspend fun getExpenseTypeById(id: Long): ExpenseType? {
        return expenseTypeDao.getExpenseTypeById(id)
    }
    
    suspend fun updateMonthlyGoal(id: Long, goal: Double) {
        expenseTypeDao.updateMonthlyGoal(id, goal)
    }
}
