package com.example.studentsapp.model

import java.io.Serializable

data class Student(
    val name: String, 
    val id: String, 
    val phone: String,
    val address: String,
    var isChecked: Boolean
) : Serializable


