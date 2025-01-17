package com.example.studentsapp.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentsapp.R
import com.example.studentsapp.model.Student

class StudentsRecyclerAdapter(private val students: MutableList<Student>?): RecyclerView.Adapter<StudentsViewHolder>() {

    var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.student_row_layout, parent, false)
        return StudentsViewHolder(itemView, listener)
    }

    override fun getItemCount(): Int {
        return students?.size ?: 0
    }

    override fun onBindViewHolder(holder: StudentsViewHolder, position: Int) {
        val student = students?.get(position)
        holder.bind(student)
    }
}