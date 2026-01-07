package com.example.finsight

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val addButton = findViewById<Button>(R.id.btnAddExpense)

        addButton.setOnClickListener {
            val intent = Intent(this,AddExpenseActivity::class.java)
            startActivity(intent)
        }

    }
}