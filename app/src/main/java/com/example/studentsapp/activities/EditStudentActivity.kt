package com.example.studentsapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.studentsapp.R
import com.example.studentsapp.model.Model
import com.example.studentsapp.model.Student

class EditStudentActivity : AppCompatActivity() {
    private var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        student = intent.getSerializableExtra("student") as? Student
        
        student?.let { loadStudentData(it) }

        findViewById<Button>(R.id.btnSave).setOnClickListener { saveStudent() }
        findViewById<Button>(R.id.btnCancel).setOnClickListener { finish() }
        findViewById<Button>(R.id.btnDelete).setOnClickListener { deleteStudent() }
    }

    private fun loadStudentData(student: Student) {
        findViewById<EditText>(R.id.etName).setText(student.name)
        findViewById<EditText>(R.id.etId).setText(student.id)
        findViewById<EditText>(R.id.etPhone).setText(student.phone)
        findViewById<EditText>(R.id.etAddress).setText(student.address)
        findViewById<CheckBox>(R.id.cbChecked).isChecked = student.isChecked
    }

    private fun saveStudent() {
        val name = findViewById<EditText>(R.id.etName).text.toString()
        val id = findViewById<EditText>(R.id.etId).text.toString()
        val phone = findViewById<EditText>(R.id.etPhone).text.toString()
        val address = findViewById<EditText>(R.id.etAddress).text.toString()
        val isChecked = findViewById<CheckBox>(R.id.cbChecked).isChecked

        student?.let {
            val updatedStudent = Student(name, id, phone, address, isChecked)
            Model.instance.updateStudent(updatedStudent)
        }
        navigateToStudentsList()
    }

    private fun deleteStudent() {
        student?.let {
            Model.instance.removeStudent(it)
        }
        navigateToStudentsList()
    }

    private fun navigateToStudentsList() {
        val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
} 