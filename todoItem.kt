package com.example.todotask

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class todoItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val description: String,
    val dateTime: Long,
    val status: Int // 0 for active, 1 for upcoming, 2 for completed){}
)