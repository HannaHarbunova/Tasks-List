package com.simpleProject.tasksList.service;

import com.simpleProject.tasksList.model.TasksList;

public interface TasksListService {

    void update(TasksList tasksList, Long id);

    void delete(Long id);

}
