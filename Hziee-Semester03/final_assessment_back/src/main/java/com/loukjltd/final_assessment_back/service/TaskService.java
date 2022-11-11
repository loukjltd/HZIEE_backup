package com.loukjltd.final_assessment_back.service;

import com.loukjltd.final_assessment_back.entity.Task;
import com.loukjltd.final_assessment_back.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
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
	
	public void taskCheckDaily(int uID, Date currentTime) throws ParseException {
		List<Task> taskList = taskMapper.getTaskList(uID);
		Calendar currentCalendar = Calendar.getInstance();
		currentCalendar.setTime(currentTime);
		for (Task task : taskList) {
			Calendar updateCalendar = Calendar.getInstance();
			updateCalendar.setTime(task.gettUpdateTime());
			Calendar refreshCalendar = Calendar.getInstance();
			refreshCalendar.setTime(task.gettRefreshTime());
			if (task.gettIfRefreshToday() == 0) {
				taskMapper.taskCheckDaily(task.gettID(), uID);
				taskMapper.taskUpdateRefreshTodayDone(task.gettID(), uID);
				Date nowJavaTime = new Date();
				taskMapper.taskUpdateRefreshTime(nowJavaTime, task.gettID(), uID);
			} else if (refreshCalendar.get(Calendar.YEAR) < currentCalendar.get(Calendar.YEAR) ||
					refreshCalendar.get(Calendar.MONTH) < currentCalendar.get(Calendar.MONTH) ||
					refreshCalendar.get(Calendar.DAY_OF_MONTH) < currentCalendar.get(Calendar.DAY_OF_MONTH) &&
							task.gettIfRefreshToday() == 1) {
				taskMapper.taskUpdateRefreshTodayUndone(task.gettID(), uID);
			}
		}
	}
	
	public int taskUpdateProgress(int uID, String tContent, Date tUpdateTime) {
		taskMapper.taskUpdateStatus(tUpdateTime, tContent, uID);
		return 100;
	}
	
	public int taskUpdateUserCoin(int uID, String tContent) {
		int currentValue = taskMapper.taskCheckValue(tContent, uID);
		taskMapper.taskUpdateUserCoin(uID, currentValue);
		return 100;
	}
	
	public void taskUpdateReadDetailTimes(int uID) {
		taskMapper.taskUpdateReadDetailTimes(uID);
	}
	
	public void taskUpdatePostDetailTimes(int uID) {
		taskMapper.taskUpdatePostDetailTimes(uID);
	}
	
	public int taskUpdatePostQuestionCostCoin(int uID) {
		if (taskMapper.taskCheckUserCoin(uID) >= 10) {
			taskMapper.taskUpdatePostQuestionCostCoin(uID);
			return 100;
		} else {
			return 144;
		}
	}
}
