package com.example.finsight

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        // THIS LINE IS CRITICAL
        installSplashScreen()

        super.onCreate(savedInstanceState)

        // DO NOT set a layout here
        // DO NOT call setContentView

        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}
