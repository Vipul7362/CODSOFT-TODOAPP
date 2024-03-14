package com.example.todotask

import androidx.lifecycle.LiveData
import androidx.room.Query
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import androidx.room.*

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task: todoItem)

    @Query("SELECT * FROM tasks WHERE status = :status")
    fun getTasksByStatus(status: Int): LiveData<List<todoItem>>
    abstract fun getTasksByStatus(): LiveData<List<todoItem>>

    @Insert
    suspend fun insertTask(task: todoItem)

    @Update
    suspend fun updateTask(task: todoItem)

    @Delete
    suspend fun deleteTask(task: todoItem)
}