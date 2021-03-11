package com.teletrac.excercise.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.teletrac.excercise.R
import com.teletrac.excercise.data.AllObjects

import kotlin.collections.ArrayList


class StudentAdapter(var context: Activity, userArrayList: ArrayList<AllObjects>) : RecyclerView.Adapter<ViewHolder>() {
    var userArrayList: ArrayList<AllObjects>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView: View = LayoutInflater.from(context).inflate(R.layout.item_recycler_view, parent, false)
        return RecyclerViewViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user: AllObjects = userArrayList[position]
        val viewHolder = holder as RecyclerViewViewHolder
        viewHolder.id_student.setText(user.dt_txt)
        viewHolder.name_student.setText(user.main.temp.toString())
        viewHolder.program_student.setText(user.main.humidity.toString())
    }

    override fun getItemCount(): Int {
        return userArrayList.size
    }

    internal inner class RecyclerViewViewHolder(itemView: View) : ViewHolder(itemView) {
        var id_student: TextView
        var name_student: TextView
        var program_student: TextView

        init {
            id_student = itemView.findViewById(R.id.id_student)
            name_student = itemView.findViewById(R.id.name_student)
            program_student = itemView.findViewById(R.id.program_student)
        }
    }

    init {
        this.userArrayList = userArrayList
    }
}
