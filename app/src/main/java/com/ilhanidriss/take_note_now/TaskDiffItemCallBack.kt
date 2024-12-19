package com.ilhanidriss.take_note_now

import androidx.recyclerview.widget.DiffUtil

class TaskDiffItemCallBack : DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task) = (oldItem.taskId == newItem.taskId)

    override fun areContentsTheSame(oldItem: Task, newItem: Task) = (oldItem == newItem)
}