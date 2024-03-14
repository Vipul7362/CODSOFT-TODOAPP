package com.example.todotask



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView




class TaskAdapter(private val tasks: List<Taskmain>) :
    ListAdapter<Taskmain, TaskAdapter.TaskViewHolder>(TaskDiffCallback()) {

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val description: TextView = itemView.findViewById(R.id.description)
        val date: TextView = itemView.findViewById(R.id.date)
        val status: TextView = itemView.findViewById(R.id.status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position] // Retrieve the task at the current position
        holder.title.text = task.title
        holder.description.text = task.description
        holder.date.text = task.date.toString()
        holder.status.text = task.status.toString()
    }

    override fun getItemCount(): Int {
        return tasks.size // Return the size of the tasks list
    }
    class TaskDiffCallback : DiffUtil.ItemCallback<Taskmain>() {
        override fun areItemsTheSame(oldItem: Taskmain, newItem: Taskmain): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Taskmain, newItem: Taskmain): Boolean {
            return oldItem.id == newItem.id // Use the '==' operator to check for equality
        }
    }
}