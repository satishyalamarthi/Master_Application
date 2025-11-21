package com.master.expensetracker.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.master.expensetracker.model.Expense

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM expenses ORDER BY date DESC")
    fun getAllExpenses(): LiveData<List<Expense>>
    
    @Query("SELECT * FROM expenses WHERE typeId = :typeId ORDER BY date DESC")
    fun getExpensesByType(typeId: Long): LiveData<List<Expense>>
    
    @Query("SELECT SUM(amount) FROM expenses WHERE typeId = :typeId AND date >= :startDate AND date <= :endDate")
    suspend fun getTotalByTypeAndDateRange(typeId: Long, startDate: Long, endDate: Long): Double?
    
    @Query("SELECT SUM(amount) FROM expenses WHERE typeId = :typeId")
    suspend fun getTotalByType(typeId: Long): Double?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(expense: Expense)
    
    @Update
    suspend fun update(expense: Expense)
    
    @Delete
    suspend fun delete(expense: Expense)
}
