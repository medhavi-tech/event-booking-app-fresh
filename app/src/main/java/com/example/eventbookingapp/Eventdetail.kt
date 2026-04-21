package com.example.eventbookingapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class Eventdetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_event_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val title = intent.getStringExtra("title")

        val date = intent.getStringExtra("date")

        val location = intent.getStringExtra("location")

        val image = intent.getIntExtra("image", 0)

        val tv = findViewById<TextView>(R.id.title)
        val tvdate = findViewById<TextView>(R.id.date)
        val tvlocation = findViewById<TextView>(R.id.location)
        val img = findViewById<ImageView>(R.id.image)
        val book = findViewById<Button>(R.id.btnBook)

        tv.text = title
        tvdate.text = date
        tvlocation.text = location
        img.setImageResource(image)
        book.setOnClickListener {
            val intent = Intent(this, Booking::class.java)
            intent.putExtra("title", title)
            intent.putExtra("image", image)
            intent.putExtra("date", date)
            intent.putExtra("location", location)
            startActivity(intent)
        }
    }
    // ✅ Menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // ✅ Menu click handling
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