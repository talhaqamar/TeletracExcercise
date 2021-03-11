package com.teletrac.excercise.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Student(
        @SerializedName("list")
        @Expose
        var id:Int,
        @SerializedName("message")
        @Expose
        var name:String,
        @SerializedName("cnt")
        @Expose
        var degree_program:String)

