package com.example.jieyi.movierater2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_landing_page.*

class landingPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.addmovie_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.add){
            val intent = Intent(this, movieRater::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    


}
