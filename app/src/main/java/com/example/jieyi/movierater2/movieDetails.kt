package com.example.jieyi.movierater2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.RatingBar
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_edit_movie.*
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.activity_movie_rater.*
import kotlinx.android.synthetic.main.activity_movie_rating.*
import android.content.SharedPreferences



class movieDetails : AppCompatActivity() {
//    class Details(title:String, overview:String, language:String, date:String, suitable:String){
//        var title: String
//        var overview: String
//        var language: String
//        var date: String
//        var suitable: String
//        init{
//            this.title = title
//            this.overview = overview
//            this.language = language
//            this.date = date
//            this.suitable = suitable
//        }
//
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        registerForContextMenu(linear)
        var review = intent.getStringExtra("rating")
        var starrating = intent.getStringExtra("bar")
        val linearLayout = findViewById<LinearLayout>(R.id.linear)
        if(review == null && starrating == null){
//        var movieInfo = Details(intent.getStringExtra("title"), intent.getStringExtra("overview"), intent.getStringExtra("language"),intent.getStringExtra("date"), intent.getStringExtra("suitable") )
        var movieInfo = MovieDetailsClass()
        nameView.text =  movieInfo.title
        descView.text =  movieInfo.overview
        languageView.text = movieInfo.language
        dateView.text = movieInfo.date
        suitableView.text = movieInfo.suitable
//        nameView.text = movieInfo.title
//        descView.text = movieInfo.overview
//        languageView.text = movieInfo.language
//        dateView.text = movieInfo.date
//        suitableView.text = movieInfo.suitable
        var addreview = TextView(this)
        addreview.text = "add review"
        linearLayout.addView(addreview)
//        val textView = findViewById<TextView>(R.id.addReview).apply {
//            text = "add a review"
//        }
        }
        else {
            nameView.text = intent.getStringExtra("title")
            descView.text = intent.getStringExtra("overview")
            languageView.text = intent.getStringExtra("language")
            dateView.text = intent.getStringExtra("date")
            suitableView.text = intent.getStringExtra("suitable")

            val ratingBar = RatingBar(this)
            ratingBar.numStars = 5
            ratingBar.setRating(starrating.toFloat())
            val showReview = TextView(this)
            showReview.textSize = 20f
            showReview.text = review
            linearLayout.addView(ratingBar)
            linearLayout.addView(showReview)

        }
    }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        getMenuInflater().inflate(R.menu.addreview_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.review){
            val intent = Intent(this, movieRating::class.java)
            intent.putExtra("title", nameView.text)
            intent.putExtra("overview", descView.text)
            intent.putExtra("language", languageView.text)
            intent.putExtra("date", dateView.text)
            intent.putExtra("suitable", suitableView.text)
            startActivity(intent)
        }
        return super.onContextItemSelected(item)
    }
}
