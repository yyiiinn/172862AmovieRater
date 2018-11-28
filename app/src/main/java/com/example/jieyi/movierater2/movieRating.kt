package com.example.jieyi.movierater2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RatingBar
import kotlinx.android.synthetic.main.activity_movie_rating.*

class movieRating : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rating)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.addrating, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.submit) {
            val rating = review.text.toString()
            val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
            val msg = ratingBar.rating.toString()
            val intent = Intent(this, movieDetails::class.java)
            intent.putExtra("rating", rating);
            intent.putExtra("bar", msg);
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)

    }
}
