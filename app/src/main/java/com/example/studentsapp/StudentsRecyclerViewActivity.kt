package com.example.studentsapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studentsapp.model.Model
import com.example.studentsapp.model.Student
import com.example.studentsapp.utils.OnItemClickListener
import com.example.studentsapp.utils.StudentsRecyclerAdapter

class StudentsRecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_recycler_view)

        val studentsRecyclerView = findViewById<RecyclerView>(R.id.betterStudentsList)
        studentsRecyclerView.setHasFixedSize(true)
        studentsRecyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = StudentsRecyclerAdapter(Model.instance.getStudents())
        adapter.listener = object : OnItemClickListener {
            override fun onItemClick(position: Int) {
                Log.i("TAG", "StudentsRecyclerAdapter: Clicked on position $position")
            }

            override fun onStudentClick(student: Student?) {
                Log.i("TAG", "Student $student")
            }
        }

        studentsRecyclerView.adapter = adapter
    }
}