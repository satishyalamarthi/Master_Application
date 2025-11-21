package com.master.expensetracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.master.expensetracker.database.ExpenseDatabase
import com.master.expensetracker.model.Expense
import com.master.expensetracker.repository.ExpenseRepository
import kotlinx.coroutines.launch

class ExpenseViewModel(application: Application) : AndroidViewModel(application) {
    
    private val repository: ExpenseRepository
    val allExpenses: LiveData<List<Expense>>
    
    init {
        val expenseDao = ExpenseDatabase.getDatabase(application).expenseDao()
        repository = ExpenseRepository(expenseDao)
        allExpenses = repository.allExpenses
    }
    
    fun getExpensesByType(typeId: Long): LiveData<List<Expense>> {
        return repository.getExpensesByType(typeId)
    }
    
    fun insert(expense: Expense) = viewModelScope.launch {
        repository.insert(expense)
    }
    
    fun update(expense: Expense) = viewModelScope.launch {
        repository.update(expense)
    }
    
    fun delete(expense: Expense) = viewModelScope.launch {
        repository.delete(expense)
    }
    
    suspend fun getTotalByTypeAndDateRange(typeId: Long, startDate: Long, endDate: Long): Double {
        return repository.getTotalByTypeAndDateRange(typeId, startDate, endDate)
    }
    
    suspend fun getTotalByType(typeId: Long): Double {
        return repository.getTotalByType(typeId)
    }
}
