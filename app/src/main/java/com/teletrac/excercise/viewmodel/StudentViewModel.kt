package com.teletrac.excercise.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teletrac.excercise.data.AllObjects
import com.teletrac.excercise.data.JSONData
import com.teletrac.excercise.data.WeatherResult
import com.teletrac.excercise.model.Student
import com.teletrac.excercise.retrofit.RetroInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

import java.util.*
import kotlin.collections.ArrayList


class StudentViewModel : ViewModel() {


    var userMutableLiveData: MutableLiveData<ArrayList<AllObjects>>
    lateinit var studentArrayList: WeatherResult
    lateinit var allRecordsArrayList: WeatherResult
    var checkFiveRecords:Int = 0

    fun init() {
//        studentArrayList = ArrayList()
//        allRecordsArrayList = ArrayList()
       // allRecordsArrayList = JSONData.parseJSON()
        populateList()

    }

    fun populateList() {
        var rf = Retrofit.Builder().baseUrl("https://samples.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(RetroInterface::class.java)

        GlobalScope.launch (Dispatchers.IO){
            val response: Response<WeatherResult> = rf.getWeatherData().awaitResponse()
            if(response.isSuccessful){
                val data: WeatherResult = response.body()!!
                Log.d("", data.list.get(0).main.humidity.toString())
                allRecordsArrayList = data
                userMutableLiveData.postValue( data.list as ArrayList<AllObjects>)
            }
        }
    }

//    private fun calculateRecords(student: ArrayList<Student>?){
//        allRecordsArrayList!!.drop(student!!.size).forEach ForEach@{
//            if (checkFiveRecords < 5 && student.size <= allRecordsArrayList!!.size) {
//                checkFiveRecords++
//                studentArrayList!!.add(it)
//            } else return@ForEach
//        }
//        checkFiveRecords = 0
//    }

    init {
        userMutableLiveData = MutableLiveData()

        // call your Rest API in init method
        init()
    }

    @JvmName("getUserMutableLiveData1")
    fun getUserMutableLiveData(): MutableLiveData<ArrayList<AllObjects>> {
        return userMutableLiveData
    }
}


