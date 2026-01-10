package com.example.finsight

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.finsight.database.AppDatabase
import com.example.finsight.database.Expense
import com.example.finsight.database.ExpenseCategory
import kotlinx.coroutines.launch

class AddExpenseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        val amountInput = findViewById<EditText>(R.id.etAmount)
        val categorySpinner = findViewById<Spinner>(R.id.spinnerCategory)
        val saveButton = findViewById<Button>(R.id.btnSaveExpense)
        val noteEditText = findViewById<EditText>(R.id.etNote)

        // Populate Spinner with categories
        val categories = ExpenseCategory.values().map { it.displayName }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categorySpinner.adapter = adapter

        val db = AppDatabase.getDatabase(this)
        val expenseDao = db.expenseDao()

        saveButton.setOnClickListener {
            val category = categorySpinner.selectedItem.toString()
            val amount = amountInput.text.toString().toDoubleOrNull()
            val note = noteEditText.text.toString().trim()

            if (category.isNotEmpty() && amount != null) {
                val expense = Expense(
                    amount = amount,
                    category = category,
                    note = if (note.isEmpty()) null else note,
                    timestamp = System.currentTimeMillis()
                )

                lifecycleScope.launch {
                    expenseDao.insertExpense(expense)
                    finish()  // close activity after saving
                }
            }
        }
    }
}
