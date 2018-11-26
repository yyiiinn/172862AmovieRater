package com.example.jieyi.movierater2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.content.Intent
import android.view.View
import kotlinx.android.synthetic.main.activity_edit_movie.*

class editMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_movie)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.editmovie_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


}
