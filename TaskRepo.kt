package com.example.todotask

// TaskRepository.kt
import androidx.lifecycle.LiveData

class TaskRepo(private val taskDao: TaskDao) {

    val allTasks: LiveData<List<todoItem>> = taskDao.getTasksByStatus()

    suspend fun insert(task: todoItem) {
        taskDao.insert(task)
    }

    fun updateTask(task: todoItem) {

    }

    fun deleteTask(task: todoItem) {

    }

    fun deleteAllTasks() {

    }

    fun allTasks(task: Any) {

    }

}