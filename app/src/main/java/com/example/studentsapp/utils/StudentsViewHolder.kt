package com.example.studentsapp.utils

import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentsapp.R
import com.example.studentsapp.model.Model
import com.example.studentsapp.model.Student

interface OnItemClickListener {
    fun onItemClick(position: Int)
    fun onStudentClick(student: Student?)
}

class StudentsViewHolder(itemView: View, listener: OnItemClickListener?) : RecyclerView.ViewHolder(itemView) {
    private var tvStudentName: TextView? = null
    private var tvStudentId: TextView? = null
    private var cbStudentIsChecked: CheckBox? = null
    private var student: Student? = null

    init {
        this.tvStudentName = itemView.findViewById<TextView>(R.id.tvStudentName)
        this.tvStudentId = itemView.findViewById<TextView>(R.id.tvStudentId)
        this.cbStudentIsChecked = itemView.findViewById<CheckBox>(R.id.cbStudentIsChecked)

        this.cbStudentIsChecked?.setOnClickListener {
            val student: Student = Model.instance.getStudents()[bindingAdapterPosition]
            student.isChecked = this.cbStudentIsChecked?.isChecked ?: false
        }

        itemView.setOnClickListener {
            Log.i("TAG", "StudentsViewHolder: Clicked on position $bindingAdapterPosition")

            listener?.onItemClick(bindingAdapterPosition)
            listener?.onStudentClick(this.student)
        }
    }

    fun bind(student: Student?) {
        this.student = student
        this.tvStudentName?.text = student?.name
        this.tvStudentId?.text = student?.id
        this.cbStudentIsChecked?.apply {
            isChecked = student?.isChecked ?: false
        }
    }
}