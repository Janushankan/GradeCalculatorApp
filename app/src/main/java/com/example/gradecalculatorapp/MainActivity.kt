package com.example.gradecalculatorapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextMarks: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var buttonReset: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextMarks = findViewById(R.id.editTextMarks)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        buttonReset = findViewById(R.id.buttonReset)
        textViewResult = findViewById(R.id.textViewResult)

        buttonCalculate.setOnClickListener {
            calculateGrade()
        }

        buttonReset.setOnClickListener {
            resetFields()
        }
    }

    private fun calculateGrade() {
        val marksText = editTextMarks.text.toString()
        if (marksText.isBlank()) {
            textViewResult.setText(R.string.enter_marks_error)
            return
        }

        val marks = marksText.toInt()
        if (marks < 0 || marks > 100) {
            textViewResult.setText(R.string.marks_range_error)
            return
        }

        val grade: String = calculateGradeFromMarks(marks)
        textViewResult.text = getString(R.string.grade_result, grade)
    }

    private fun calculateGradeFromMarks(marks: Int): String {
        return when {
            marks >= 75 -> "A"
            marks >= 65 -> "B"
            marks >= 55 -> "C"
            marks >= 40 -> "D"
            else -> "F"
        }
    }

    private fun resetFields() {
        editTextMarks.text.clear()
        textViewResult.text = ""
    }
}
