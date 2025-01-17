package com.example.studentsapp.model

import java.io.Serializable

data class Student(
    val name: String, 
    val id: String, 
    val avatar: String, 
    val address: String,
    val phone: String,
    var isChecked: Boolean
) : Serializable


