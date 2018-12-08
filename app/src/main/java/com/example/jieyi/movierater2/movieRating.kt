package com.example.jieyi.movierater2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RatingBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_movie_rating.*

class movieRating : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rating)
        val textView = findViewById<TextView>(R.id.textView6).apply {
            text = "Enter your review for the movie: " + intent.getStringExtra("title")
        }
        var title = intent.getStringExtra("title")
        var overview = intent.getStringExtra("overview")
        var language = intent.getStringExtra("language")
        var date = intent.getStringExtra("date")
        var suitable = intent.getStringExtra("suitable")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.addrating_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.submit) {
            val rating = review.text.toString()
            val msg = ratingBar.rating.toString()
            var title = intent.getStringExtra("title")
            var overview = intent.getStringExtra("overview")
            var language = intent.getStringExtra("language")
            var date = intent.getStringExtra("date")
            var suitable = intent.getStringExtra("suitable")
            val intent = Intent(this, movieDetails::class.java)
            intent.putExtra("rating", rating);
            intent.putExtra("bar", msg)
            intent.putExtra("title", title)
            intent.putExtra("overview", overview)
            intent.putExtra("language", language)
            intent.putExtra("date", date)
            intent.putExtra("suitable", suitable)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)

    }
}
