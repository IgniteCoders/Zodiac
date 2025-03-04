package com.example.zodiac

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_HOROSCOPE_ID = "HOROSCOPE_ID"
    }

    lateinit var nameTextView: TextView
    lateinit var dateTextView: TextView
    lateinit var iconImageView: ImageView

    lateinit var horoscope: Horoscope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_detail)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val id = intent.getStringExtra(EXTRA_HOROSCOPE_ID)!!
        horoscope = Horoscope.findById(id)

        initView()

        loadData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_activity_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_favorite -> {
                Log.i("MENU", "Menu favorito")
                true
            }
            R.id.action_share -> {
                Log.i("MENU", "Menu compartir")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun loadData() {
        supportActionBar?.setTitle(horoscope.name)
        supportActionBar?.setSubtitle(horoscope.dates)

        nameTextView.setText(horoscope.name)
        dateTextView.setText(horoscope.dates)
        iconImageView.setImageResource(horoscope.icon)
    }

    private fun initView() {
        nameTextView = findViewById(R.id.nameTextView)
        dateTextView = findViewById(R.id.dateTextView)
        iconImageView = findViewById(R.id.iconImageView)
    }
}