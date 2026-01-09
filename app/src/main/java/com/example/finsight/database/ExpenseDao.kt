package com.example.finsight.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ExpenseDao {

    @Insert
    suspend fun insertExpense(expense: Expense)

    @Query("Select * FROM expenses ORDER BY timestamp DESC")
    suspend fun getAllExpenses(): List<Expense>

}