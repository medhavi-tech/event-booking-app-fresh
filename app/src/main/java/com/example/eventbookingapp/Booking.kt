package com.example.eventbookingapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class Booking : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        // ✅ Toolbar
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Buttons
        val paynow = findViewById<Button>(R.id.btnPay)
        val cancel = findViewById<Button>(R.id.btnCancel)

        paynow.setOnClickListener {
            Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show()
            finish()
        }

        cancel.setOnClickListener {
            Toast.makeText(this, "Payment Cancelled", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    // ✅ MENU CREATE
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // ✅ MENU CLICK HANDLER
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.menu_bookings -> {
                startActivity(Intent(this, Mybookings::class.java))
                true
            }

            R.id.menu_info -> {
                startActivity(Intent(this, appInfo::class.java))
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}