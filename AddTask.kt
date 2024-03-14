package com.example.todotask


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import java.util.Calendar

import java.text.SimpleDateFormat
import java.util.*



class AddTask :AppCompatActivity() {


    private lateinit var btnAdd:Button
    private lateinit var title1: EditText
    private lateinit var description1: EditText
    private lateinit var datetime:TextView
    private lateinit var status:RadioGroup
    private lateinit var viewModel: Taskviewmodel
    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_task)

        btnAdd=findViewById(R.id.BtnAdd)
        title1=findViewById(R.id.tasktitle)
        description1=findViewById(R.id.taskdescription)


        val view = View.inflate(this, R.layout.add_task, null)
        val taskTitle = view.findViewById<EditText>(R.id.tasktitle)
        status=findViewById(R.id.taskstatus)

        viewModel.allTasks.observe(this, androidx.lifecycle.Observer { tasks ->
        })


            btnAdd.setOnClickListener {

                val title = taskTitle.text.toString()
                val description = description1.text.toString() // Add code to get the description
                val dateTime = System.currentTimeMillis() // Add code to get the date and time
                val status = 0 // 0 for active

                val task =todoItem(0, description, dateTime, status)

                viewModel.insert(task)

                val intent= Intent(this,MainActivity::class.java)

                startActivity(intent)


            }


            // Set the current date and time as default values

            selectedDateTimeTextView = findViewById(R.id.selectedDateTimeTextView)
            selectedDateTimeTextView.text =
                SimpleDateFormat("MMMM dd, yyyy hh:mm a", Locale.getDefault()).format(calendar.time)

            // Set a click listener for the button
            selectDateTimeButton = findViewById(R.id.selectDateTimeButton)
            selectDateTimeButton.setOnClickListener {
                showDatePickerDialog()
            }
        }


    private fun showDatePickerDialog() {
        val datePicker = DatePickerDialog(this, { _, year, month, day ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, day)
            showTimePickerDialog(calendar)
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))

        // Show the DatePickerDialog
        datePicker.show()
    }

    private fun showTimePickerDialog(calendar: Calendar) {
        val timePicker = TimePickerDialog(this, { _, hour, minute ->
            calendar.set(Calendar.HOUR_OF_DAY, hour)
            calendar.set(Calendar.MINUTE, minute)
            selectedDateTimeTextView.text = SimpleDateFormat("MMMM dd, yyyy hh:mm a", Locale.getDefault()).format(calendar.time)
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true)

        // Show the TimePickerDialog
        timePicker.show()
    }

    companion object {
        lateinit var selectedDateTimeTextView: TextView
        lateinit var selectDateTimeButton: Button
    }





}

