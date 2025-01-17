package com.example.studentsapp.activities

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.studentsapp.R
import com.example.studentsapp.model.Student

class StudentDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val student = intent.getSerializableExtra("student") as? Student
        
        student?.let {
            findViewById<TextView>(R.id.studentName).text = it.name
            findViewById<TextView>(R.id.studentId).text = it.id
            findViewById<TextView>(R.id.studentPhone).text = it.phone
            findViewById<TextView>(R.id.studentAddress).text = it.address
            findViewById<CheckBox>(R.id.studentChecked).isChecked = it.isChecked
            findViewById<ImageView>(R.id.studentDetailImage).setImageResource(R.drawable.ic_launcher_background)
        }

        findViewById<Button>(R.id.editButton).setOnClickListener {
            // TODO: Implement edit functionality
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
} 