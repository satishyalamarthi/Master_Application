package com.master.expensetracker.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.master.expensetracker.model.ExpenseType

@Dao
interface ExpenseTypeDao {
    @Query("SELECT * FROM expense_types ORDER BY name ASC")
    fun getAllExpenseTypes(): LiveData<List<ExpenseType>>
    
    @Query("SELECT * FROM expense_types WHERE id = :id")
    suspend fun getExpenseTypeById(id: Long): ExpenseType?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(expenseType: ExpenseType): Long
    
    @Update
    suspend fun update(expenseType: ExpenseType)
    
    @Delete
    suspend fun delete(expenseType: ExpenseType)
    
    @Query("UPDATE expense_types SET monthlyGoal = :goal WHERE id = :id")
    suspend fun updateMonthlyGoal(id: Long, goal: Double)
}
