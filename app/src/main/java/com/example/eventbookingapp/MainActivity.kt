package com.example.eventbookingapp

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create layout manually (bypass XML issue)
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setBackgroundColor(android.graphics.Color.WHITE)

        val title = TextView(this)
        title.text = "EVENT LIST"
        title.textSize = 22f
        title.setTextColor(android.graphics.Color.BLACK)

        val recyclerView = RecyclerView(this)

        layout.addView(title)
        layout.addView(recyclerView)

        setContentView(layout)

        // Data
        val dataList = arrayListOf(
            event(R.drawable.img, "Concert", "12 Aug", "Delhi"),
            event(R.drawable.img_1, "Movie", "15 Aug", "Mumbai"),
            event(R.drawable.img_2, "Workshop", "18 Aug", "Lucknow"),
            event(R.drawable.img_3, "Seminar", "20 Aug", "Kerala")
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdapterClass(dataList)
    }
}