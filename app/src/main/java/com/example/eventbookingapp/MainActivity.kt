package com.example.eventbookingapp

import android.content.Intent
import android.health.connect.datatypes.AppInfo
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<event>
    private lateinit var adapter: AdapterClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ✅ Toolbar setup
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // ✅ RecyclerView setup
        recyclerView = findViewById(R.id.recyclerview)

        val imageList = arrayOf( R.mipmap.demo, R.mipmap.demo, R.mipmap.demo, R.mipmap.demo, R.mipmap.demo, R.mipmap.demo, R.mipmap.demo, R.mipmap.demo, R.mipmap.demo, R.mipmap.demo )

        val titleList = arrayOf(
            "Concert",
            "Movie",
            "Workshop",
            "Seminar",
            "Sports",
            "Festival",
            "Conference",
            "Exhibition",
            "Meetup",
            "Party"
        )

        val dateList = arrayOf(
            "12 Aug 2026",
            "15 Aug 2026",
            "18 Aug 2026",
            "20 Aug 2026",
            "22 Aug 2026",
            "25 Aug 2026",
            "28 Aug 2026",
            "30 Aug 2026",
            "2 Sep 2026",
            "5 Sep 2026"
        )

        val locationList = arrayOf(
            "Delhi",
            "Mumbai",
            "Lucknow",
            "Kerala",
            "Tamil Nadu",
            "Haryana",
            "Gurgaon",
            "Jaipur",
            "Chandigarh",
            "Punjab"
        )

        dataList = ArrayList()

        for (i in imageList.indices) {
            val event = event(
                imageList[i],
                titleList[i],
                dateList[i],
                locationList[i]
            )
            dataList.add(event)
        }

        adapter = AdapterClass(dataList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        // ✅ Item click
        adapter.onItemClick = { item ->
            val intent = Intent(this, Eventdetail::class.java)
            intent.putExtra("title", item.title)
            intent.putExtra("date", item.date)
            intent.putExtra("location", item.location)
            intent.putExtra("image", item.Dataimage)
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