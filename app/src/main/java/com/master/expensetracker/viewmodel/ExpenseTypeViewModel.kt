package com.master.expensetracker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.master.expensetracker.database.ExpenseDatabase
import com.master.expensetracker.model.ExpenseType
import com.master.expensetracker.repository.ExpenseTypeRepository
import kotlinx.coroutines.launch

class ExpenseTypeViewModel(application: Application) : AndroidViewModel(application) {
    
    private val repository: ExpenseTypeRepository
    val allExpenseTypes: LiveData<List<ExpenseType>>
    
    init {
        val expenseTypeDao = ExpenseDatabase.getDatabase(application).expenseTypeDao()
        repository = ExpenseTypeRepository(expenseTypeDao)
        allExpenseTypes = repository.allExpenseTypes
    }
    
    fun insert(expenseType: ExpenseType) = viewModelScope.launch {
        repository.insert(expenseType)
    }
    
    fun update(expenseType: ExpenseType) = viewModelScope.launch {
        repository.update(expenseType)
    }
    
    fun delete(expenseType: ExpenseType) = viewModelScope.launch {
        repository.delete(expenseType)
    }
    
    fun updateMonthlyGoal(id: Long, goal: Double) = viewModelScope.launch {
        repository.updateMonthlyGoal(id, goal)
    }
    
    suspend fun getExpenseTypeById(id: Long): ExpenseType? {
        return repository.getExpenseTypeById(id)
    }
}
