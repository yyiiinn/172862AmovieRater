package com.example.jieyi.movierater2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_movie_rater.*
import android.widget.Toast


class movieRater : AppCompatActivity() {
    var suitable = ""
    var language = ""
    var violenceText = ""
    var notSuitable = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rater)
        suitableage.setOnClickListener(View.OnClickListener{
            if(suitableage.isChecked == true){
                violence.visibility= View.VISIBLE
                languageUsed.visibility= View.VISIBLE
                suitable="Suitable for all ages = false" + "\n"
            }
            if(suitableage.isChecked == false){
                violence.visibility= View.INVISIBLE
                languageUsed.visibility= View.INVISIBLE
                suitable="Suitable for all ages = true" + "\n"
            }
        })
        languageUsed.setOnClickListener(View.OnClickListener{
            if(languageUsed.isChecked == true){
                language = "Language"
            }
            if(languageUsed.isChecked == false){
                language = ""
            }
        })
        violence.setOnClickListener(View.OnClickListener{
            if(violence.isChecked == true){
                violenceText = "Violence"
            }
            if(violence.isChecked == false){
                violenceText = ""
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
//        textView4.text="clicked"
        var name = namefield.getText().toString()
        var description = descfield.getText().toString()
        var date = releasedate.getText().toString()
        val duration = Toast.LENGTH_SHORT
        if(language == ""){
            notSuitable = "Reason"  + "\n" + violenceText
        }
        if(violenceText == ""){
            notSuitable = "Reason"  + "\n" + language
        }
        if(language != "" && violenceText != ""){
            notSuitable = "Reason"  + "\n" + language + "\n" + violenceText
        }
        val toast = Toast.makeText(applicationContext, "title="+name+"\n"+"Overview="+description+"\n"+"Release Date="+date+"\n"+"Language="+radio()+"\n"+suitable+notSuitable, duration)
        if(btnValidate() == true){
            toast.show()
        }
    }
}
