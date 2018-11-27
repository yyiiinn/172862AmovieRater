package com.example.jieyi.movierater2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_movie_rater.*
import android.widget.Toast


class movieRater : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rater)
        suitableage.setOnClickListener(View.OnClickListener{
            if(suitableage.isChecked == true){
                violence.visibility= View.VISIBLE
                languageUsed.visibility= View.VISIBLE
            }
            if(suitableage.isChecked == false){
                violence.visibility= View.INVISIBLE
                languageUsed.visibility= View.INVISIBLE
            }
        })
    }
    fun btnValidate():Boolean{
        var check = true;
        if(namefield.getText().isNullOrEmpty()){
            namefield.setError("Field Empty")
            check = false;
        }
        if(descfield.getText().isNullOrEmpty()){
            descfield.setError("Field Empty")
            check = false;
        }
        if(releasedate.getText().isNullOrEmpty()){
            releasedate.setError("Field Empty")
            check = false;
        }
        return check
    }
    fun radio():String{
        var language = ""
        var id = radioGroup.checkedRadioButtonId;
        when (id) {
            R.id.radioButton -> language = "English"
            R.id.radioButton2 -> language = "Chinese"
            R.id.radioButton3 -> language = "Malay"
            R.id.radioButton4 -> language = "Tamil"
        }
        return language
    }
    fun btnClick(v: View){
        var suitable = ""
        var text = ""
        var name = namefield.getText().toString()
        var description = descfield.getText().toString()
        var date = releasedate.getText().toString()
        val duration = Toast.LENGTH_SHORT
        if(languageUsed.isChecked == true){
           text += "Language" + "\n"
        }
        if(violence.isChecked == true){
            text += "Violence"
        }
        if(suitableage.isChecked == true && (languageUsed.isChecked == true || violence.isChecked == true)){
            suitable = "Suitable for all ages = false" + "\n" + "Reason" + "\n"
        }
        else if(suitableage.isChecked == true && (languageUsed.isChecked == false && violence.isChecked == false)){
            suitable = "Suitable for all ages = false" + "\n"
        }
        else if(suitableage.isChecked == false){
            suitable = "Suitable for all ages = true" + "\n"
        }
        val toast = Toast.makeText(applicationContext,  "title="+name+"\n"+"Overview="+description+"\n"+"Release Date="+date+"\n"+"Language="+radio()+"\n"+suitable+text, duration)
        if(btnValidate() == true){
            toast.show()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.movieadd_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.clear){
             namefield.getText().clear()
             descfield.getText().clear()
             releasedate.getText().clear()
            if(suitableage.isChecked()) {
                suitableage.toggle()
            }
            violence.visibility= View.INVISIBLE
            languageUsed.visibility= View.INVISIBLE
             languageUsed.isChecked = false
            if(radio() != "English"){
                radioButton.setChecked(true);
            }
        }
        if(item?.itemId == R.id.addMovie){
            val intent = Intent(this, movieDetails::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}
