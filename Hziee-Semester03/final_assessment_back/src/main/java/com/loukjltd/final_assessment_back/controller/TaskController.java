package com.loukjltd.final_assessment_back.controller;

import com.loukjltd.final_assessment_back.entity.Task;
import com.loukjltd.final_assessment_back.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class TaskController {
	private final TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@RequestMapping("Task")
	@ResponseBody
	public List<Task> getTask(@RequestBody Map<String, Object> map) {
		int uID = Integer.parseInt(map.get("uID").toString());
		return taskService.getTaskList(uID);
	}
	
	@RequestMapping("TaskUpdateStatus")
	@ResponseBody
	public int TaskUpdateProgress(@RequestBody Map<String, Object> map) {
		int uID = Integer.parseInt(map.get("uID").toString());
		String tContent = map.get("tContent").toString();
		return taskService.TaskUpdateProgress(uID, tContent);
	}
	
	@RequestMapping("TaskUpdateUserCoin")
	@ResponseBody
	public int TaskUpdateUserCoin(@RequestBody Map<String, Object> map) {
		int uID = Integer.parseInt(map.get("uID").toString());
		String tContent = map.get("tContent").toString();
		return taskService.TaskUpdateUserCoin(uID, tContent);
	}
	
}
