package com.loukjltd.final_assessment_back.controller;

import com.loukjltd.final_assessment_back.entity.Task;
import com.loukjltd.final_assessment_back.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	@RequestMapping("TaskCheckDaily")
	@ResponseBody
	public void taskCheckDaily(@RequestBody Map<String, Object> map) throws ParseException {
		int uID = Integer.parseInt(map.get("uID").toString());
		String dateFormat = "yyyy/MM/dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		String currentTime = map.get("currentTime").toString();
		Date stringCurrentTime = sdf.parse(currentTime);
		taskService.taskCheckDaily(uID, stringCurrentTime);
	}
	
	@RequestMapping("TaskUpdateStatus")
	@ResponseBody
	public int TaskUpdateProgress(@RequestBody Map<String, Object> map) throws ParseException {
		int uID = Integer.parseInt(map.get("uID").toString());
		String tContent = map.get("tContent").toString();
		String dateFormat = "yyyy/MM/dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		String tUpdateTime = map.get("tUpdateTime").toString();
		Date convertedTime = sdf.parse(tUpdateTime);
		return taskService.taskUpdateProgress(uID, tContent, convertedTime);
	}
	
	@RequestMapping("TaskUpdateUserCoin")
	@ResponseBody
	public int TaskUpdateUserCoin(@RequestBody Map<String, Object> map) {
		int uID = Integer.parseInt(map.get("uID").toString());
		String tContent = map.get("tContent").toString();
		return taskService.taskUpdateUserCoin(uID, tContent);
	}
	
	@RequestMapping("TaskUpdateReadDetailTimes")
	@ResponseBody
	public void TaskUpdateReadDetailTimes(@RequestBody Map<String, Object> map) {
		int uID = Integer.parseInt(map.get("uID").toString());
		taskService.taskUpdateReadDetailTimes(uID);
	}
	
	@RequestMapping("TaskUpdatePostDetailTimes")
	@ResponseBody
	public void TaskUpdateReadPostTimes(@RequestBody Map<String, Object> map) {
		int uID = Integer.parseInt(map.get("uID").toString());
		taskService.taskUpdatePostDetailTimes(uID);
	}
	
	@RequestMapping("taskUpdatePostQuestionCostCoin")
	@ResponseBody
	public int taskUpdatePostQuestionTimes(@RequestBody Map<String, Object> map) {
		int uID = Integer.parseInt(map.get("uID").toString());
		return taskService.taskUpdatePostQuestionCostCoin(uID);
	}
}
