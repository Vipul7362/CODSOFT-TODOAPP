package com.example.todotask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var btn:Button
    private lateinit var taskViewModel: Taskviewmodel
    private lateinit var taskDao: TaskDao
    private lateinit var taskDatabase: TaskDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)






        btn=findViewById(R.id.button)

        btn.setOnClickListener {
            val intent=Intent(this,AddTask::class.java)

            startActivity(intent)



        }

    }


}

