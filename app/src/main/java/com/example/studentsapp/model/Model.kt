package com.example.studentsapp.model

class Model private constructor() {

    private val students: MutableList<Student> = ArrayList()

    companion object {
        val instance = Model()
    }

    init {
        for (i in 1..20) {
            students.add(Student("Student $i", "$i", "http://me.png/$i", "Address $i", false))
        }
    }

    fun getStudents(): MutableList<Student> {
        return this.students
    }

    fun getStudentById(id: String): Student? {
        for (student in this.students) {
            if (student.id == id) {
                return student
            }
        }
        return null
    }

    fun addStudent(student: Student) {
        this.students.add(student)
    }

    fun removeStudent(student: Student) {
        this.students.remove(student)
    }

    fun updateStudent(student: Student) {
        val index = this.students.indexOf(student)
        this.students[index] = student
    }

}