package com.example.studentsapp.activities

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.studentsapp.R
import com.example.studentsapp.model.Model
import com.example.studentsapp.model.Student

class CreateStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_student)
    }

    fun closeActivity(view: View) {
        finish()
    }

    fun saveStudent(view: View) {
        val studentName = findViewById<EditText>(R.id.tvNameInput).text.toString()
        val studentId = findViewById<EditText>(R.id.tvIdInput).text.toString()
        val studentPhone = findViewById<EditText>(R.id.tvPhoneInput).text.toString()
        val studentAddress = findViewById<EditText>(R.id.tvAddressInput).text.toString()
        val studentIsChecked = findViewById<CheckBox>(R.id.btnCheckbox).isChecked

        val student = Student(studentName, studentId, studentPhone, studentAddress, studentIsChecked)
        Model.instance.addStudent(student)
        this.closeActivity(view)
    }


}