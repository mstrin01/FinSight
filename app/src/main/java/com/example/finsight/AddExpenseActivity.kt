package com.example.finsight

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import com.example.finsight.database.AppDatabase
import com.example.finsight.database.Expense
import kotlinx.coroutines.launch


class AddExpenseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        val amountInput = findViewById<EditText>(R.id.etAmount)
        val categoryInput = findViewById<EditText>(R.id.etCategory)
        val saveButton = findViewById<Button>(R.id.btnSaveExpense)
        val noteEditText = findViewById<EditText>(R.id.etNote)

        val db = AppDatabase.getDatabase(this)
        val expenseDao = db.expenseDao()
        
        saveButton.setOnClickListener { 
            val category = categoryInput.text.toString()
            val amount = amountInput.text.toString().toDoubleOrNull()
            val note = noteEditText.text.toString().trim()
            
            if(category.isNotEmpty() && amount != null)
            {
                val expense = Expense(
                    category = category,
                    amount = amount,
                    note = if (note.isEmpty()) null else note,
                    timestamp = System.currentTimeMillis()

                )
                
                lifecycleScope.launch { 
                    expenseDao.insertExpense(expense)
                    finish()
                }
            }
        }
        


    }


}
