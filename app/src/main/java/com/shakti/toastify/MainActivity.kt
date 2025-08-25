package com.shakti.toastify

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnSuccess).setOnClickListener {
            ToastManager.showToast(this, "Login successful 🎉", ToastType.SUCCESS)
        }

        findViewById<Button>(R.id.btnError).setOnClickListener {
            ToastManager.showToast(this, "Something went wrong ❌", ToastType.ERROR)
        }

        findViewById<Button>(R.id.btnNeutral).setOnClickListener {
            ToastManager.showToast(this, "This is a neutral message ℹ️", ToastType.NEUTRAL)
        }
    }
}