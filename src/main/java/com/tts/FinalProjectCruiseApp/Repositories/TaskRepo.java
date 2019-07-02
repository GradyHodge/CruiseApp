package com.tts.FinalProjectCruiseApp.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.FinalProjectCruiseApp.Model.Task;

@Repository
public interface TaskRepo extends CrudRepository<Task, Long> {

}
