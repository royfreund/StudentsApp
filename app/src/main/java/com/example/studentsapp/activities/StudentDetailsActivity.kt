package com.example.studentsapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.studentsapp.R
import com.example.studentsapp.model.Model
import com.example.studentsapp.model.Student

class StudentDetailsActivity : AppCompatActivity() {

    private var student: Student? = null
    private var studentIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        studentIndex = intent.getIntExtra("student_index", 0)

        student = Model.instance.getStudentByIndex(studentIndex)

        findViewById<TextView>(R.id.studentName).text = student?.name
        findViewById<TextView>(R.id.studentId).text = student?.id
        findViewById<TextView>(R.id.studentPhone).text = student?.phone
        findViewById<TextView>(R.id.studentAddress).text = student?.address
        findViewById<CheckBox>(R.id.studentChecked).isChecked = student?.isChecked ?: false
        findViewById<ImageView>(R.id.studentDetailImage).setImageResource(R.drawable.ic_launcher_background)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun openEditStudentActivity(view: View) {
        val newIntent: Intent = Intent(view.context, EditStudentActivity::class.java)
        newIntent.putExtra("student_index", intent.getIntExtra("student_index", 0))
        view.context.startActivity(newIntent)
        finish()
    }

} 