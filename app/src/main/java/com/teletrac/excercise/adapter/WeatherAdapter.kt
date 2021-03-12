package com.teletrac.excercise.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import com.teletrac.excercise.R
import com.teletrac.excercise.data.AllObjects
import kotlinx.datetime.toKotlinLocalDate
import java.time.Instant
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

import kotlin.collections.ArrayList


class WeatherAdapter(var context: Activity, userArrayList: ArrayList<AllObjects>) : RecyclerView.Adapter<ViewHolder>() {
    var userArrayList: ArrayList<AllObjects>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView: View = LayoutInflater.from(context).inflate(R.layout.item_recycler_view, parent, false)
        return RecyclerViewViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val record: AllObjects = userArrayList[position]
        val viewHolder = holder as RecyclerViewViewHolder

        viewHolder.rain_main_textview.setText(record.weather.get(0).main)
        viewHolder.rain_main_sub_textview.setText(record.dt_txt.toString())

        Picasso.get().load("https://openweathermap.org/img/wn/"+ record.weather.get(0).icon + "@2x.png").into(viewHolder.rain_main_imageview);
        viewHolder.main_date_textview.setText(getDate(record.dt_txt.toString()))
        viewHolder.rain_main_sub_textview.setText(getDate(record.dt_txt.toString()))

    }

    private fun getDate(dtTxt: String): String
    {
        val firstApiFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val date = LocalDate.parse(dtTxt , firstApiFormat)
        val newDate = date.dayOfMonth.toString() + " " + date.month + " " + date.year
        return  newDate
    }

    override fun getItemCount(): Int {
        return userArrayList.size
    }

    internal inner class RecyclerViewViewHolder(itemView: View) : ViewHolder(itemView) {
        var main_date_textview: TextView
        var rain_main_imageview: ImageView
        var rain_main_textview: TextView

        var rain_main_sub_textview: TextView

        var rain_secondary_imageview1: ImageView
        var rain_secondary_imageview2: ImageView
        var rain_secondary_imageview3: ImageView

        var rain_secondary_textview1: TextView
        var rain_secondary_textview2: TextView
        var rain_secondary_textview3: TextView



        init {
            main_date_textview = itemView.findViewById(R.id.main_date_textview)
            rain_main_imageview = itemView.findViewById(R.id.rain_main_imageview)
            rain_main_textview = itemView.findViewById(R.id.rain_main_textview)
            rain_main_sub_textview = itemView.findViewById(R.id.rain_main_sub_textview)



            rain_secondary_imageview1 = itemView.findViewById(R.id.rain_secondary_imageview1)
            rain_secondary_imageview2 = itemView.findViewById(R.id.rain_secondary_imageview2)
            rain_secondary_imageview3 = itemView.findViewById(R.id.rain_secondary_imageview3)
            rain_secondary_textview1 = itemView.findViewById(R.id.rain_secondary_textview1)
            rain_secondary_textview2 = itemView.findViewById(R.id.rain_secondary_textview2)
            rain_secondary_textview3 = itemView.findViewById(R.id.rain_secondary_textview3)


        }
    }

    init {
        this.userArrayList = userArrayList
    }
}
