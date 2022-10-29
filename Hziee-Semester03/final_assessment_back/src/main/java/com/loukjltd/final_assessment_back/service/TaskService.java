package com.loukjltd.final_assessment_back.service;

import com.loukjltd.final_assessment_back.entity.Task;
import com.loukjltd.final_assessment_back.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
	private final TaskMapper taskMapper;
	
	public TaskService(TaskMapper taskMapper) {
		this.taskMapper = taskMapper;
	}
	
	public List<Task> getTaskList(int uID) {
		return taskMapper.getTaskList(uID);
	}
	
	public int TaskUpdateProgress(int uID, String tContent) {
		taskMapper.taskUpdateStatus(tContent, uID);
		return 100;
	}
	
	public int TaskUpdateUserCoin(int uID, String tContent) {
		int currentValue = taskMapper.taskCheckValue(tContent, uID);
		taskMapper.taskUpdateUserCoin(uID, currentValue);
		return 100;
	}
}
