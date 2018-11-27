package com.example.jieyi.movierater2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_movie_details.*

class movieDetails : AppCompatActivity() {
    class Details(title:String, overview:String, language:String, date:String, suitable:Boolean){
        var title: String
        var overview: String
        var language: String
        var date: String
        var suitable: Boolean
        init{
            this.title = title
            this.overview = overview
            this.language = language
            this.date = date
            this.suitable = suitable
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        registerForContextMenu(addReview)
        var movieInfo = Details("Venom", "When eddy Brock acquires the powers of a symbiote, he will have to release his alter-ego Venom to save his life", "English", "03-10-2018", true)
        nameView.text = movieInfo.title
        descView.text = movieInfo.overview
        languageView.text = movieInfo.language
        dateView.text = movieInfo.date
        var suitable = ""
        if (movieInfo.suitable == true){
            suitable = "Yes"
        }
        else
            suitable = "No"
        suitableView.text = suitable
    }
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        getMenuInflater().inflate(R.menu.addreview_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.review){
            val intent = Intent(this, movieRating::class.java)
            startActivity(intent)
        }
        return super.onContextItemSelected(item)
    }
}
