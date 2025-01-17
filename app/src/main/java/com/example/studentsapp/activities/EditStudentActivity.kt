package com.example.studentsapp.activities

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.studentsapp.R
import com.example.studentsapp.model.Model
import com.example.studentsapp.model.Student

class EditStudentActivity : AppCompatActivity() {
    private var student: Student? = null
    private var studentIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        studentIndex = intent.getIntExtra("student_index", 0)
        student = Model.instance.getStudentByIndex(studentIndex)

        loadStudentData(student)
    }

    private fun loadStudentData(student: Student?) {
        findViewById<EditText>(R.id.etName).setText(student?.name)
        findViewById<EditText>(R.id.etId).setText(student?.id)
        findViewById<EditText>(R.id.etPhone).setText(student?.phone)
        findViewById<EditText>(R.id.etAddress).setText(student?.address)
        findViewById<CheckBox>(R.id.cbChecked).isChecked = student?.isChecked ?: false
    }

    fun updateStudent(view: View) {
        val name = findViewById<EditText>(R.id.etName).text.toString()
        val id = findViewById<EditText>(R.id.etId).text.toString()
        val phone = findViewById<EditText>(R.id.etPhone).text.toString()
        val address = findViewById<EditText>(R.id.etAddress).text.toString()
        val isChecked = findViewById<CheckBox>(R.id.cbChecked).isChecked

        val updatedStudent = Student(name, id, phone, address, isChecked)
        Model.instance.updateStudent(studentIndex, updatedStudent)

        closeActivity(view)
    }

    fun deleteStudent(view: View) {
        Model.instance.removeStudent(studentIndex)

        closeActivity(view)
    }

    fun closeActivity(view: View) {
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}