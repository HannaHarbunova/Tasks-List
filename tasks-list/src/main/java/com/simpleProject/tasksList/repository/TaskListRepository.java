package com.simpleProject.tasksList.repository;

import com.simpleProject.tasksList.model.TasksList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskListRepository extends JpaRepository<TasksList,Long> {

    List<TasksList> findByUserUserName(String userName);
}
