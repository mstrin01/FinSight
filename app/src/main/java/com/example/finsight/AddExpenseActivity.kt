package com.example.finsight

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import android.widget.EditText


class AddExpenseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        val amountInput = findViewById<EditText>(R.id.etAmount)
        val categoryInput = findViewById<EditText>(R.id.etCategory)
        val saveButton = findViewById<Button>(R.id.btnSaveExpense)

        saveButton.setOnClickListener {
            val amount = amountInput.text.toString()
            val category = categoryInput.text.toString()

            if(amount.isBlank() || category.isBlank()){
                Toast.makeText(this,"Please fill in all fields!", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this,"Expense saved: €$amount | $category",Toast.LENGTH_SHORT).show()
                finish()
            }

        }
    }


}
