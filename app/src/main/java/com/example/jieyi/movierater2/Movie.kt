package com.example.jieyi.movierater2

class MovieDetails(title:String, overview:String, language:String, date:String, suitable:String){
    var title: String
    var overview: String
    var language: String
    var date: String
    var suitable: String
    init{
        this.title = title
        this.overview = overview
        this.language = language
        this.date = date
        this.suitable = suitable
    }

}