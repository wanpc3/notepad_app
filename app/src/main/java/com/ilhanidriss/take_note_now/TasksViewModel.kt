package com.ilhanidriss.take_note_now

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TasksViewModel(val dao: TaskDao): ViewModel() {

    //Expose tasks as LiveData
    val tasks: LiveData<List<Task>> = dao.getAll()

    val newTaskName = MutableLiveData<String>()

    fun addTask() {
        viewModelScope.launch(Dispatchers.IO) {
            val taskName = newTaskName.value
            if (!taskName.isNullOrBlank()) {
                val task = Task(taskName = taskName)
                dao.insert(task)
            }
        }
    }

    /*
    fun addTask() {
        viewModelScope.launch {
            val task = Task()
            task.taskName = newTaskName
            dao.insert(task)
        }
    }
    */
}