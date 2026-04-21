package com.example.eventbookingapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        // Step 1: Connect button from XML
        val payBtn = findViewById<Button>(R.id.payBtn)

        // Step 2: Add click listener HERE
        payBtn.setOnClickListener {

            // Step 3: Payment options
            val options = arrayOf("UPI", "Card", "Net Banking")

            // Step 4: Create dialog
            val builder = AlertDialog.Builder(this@PaymentActivity)
            builder.setTitle("Choose Payment Method")

            builder.setItems(options) { _, which ->

                // Step 5: Show selected option
                Toast.makeText(
                    this@PaymentActivity,
                    "Payment Successful via ${options[which]}",
                    Toast.LENGTH_LONG
                ).show()
            }

            // Step 6: Show dialog
            val dialog = builder.create()
            dialog.show()
        }
    }
}