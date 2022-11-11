package com.loukjltd.final_assessment_back.controller;


import com.loukjltd.final_assessment_back.entity.Notification;
import com.loukjltd.final_assessment_back.service.NotificationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class NotificationController {
	private final NotificationService notificationService;
	
	public NotificationController(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
	
	@RequestMapping("Notification")
	@ResponseBody
	public List<Notification> getNotificationList(@RequestBody Map<String, Object> map) {
		int uID = Integer.parseInt(map.get("uID").toString());
		return notificationService.getNotificationList(uID);
	}
	
	@RequestMapping("DeleteNotification")
	@ResponseBody
	public int deleteNotification(@RequestBody Map<String, Object> map) {
		int uID = Integer.parseInt(map.get("uID").toString());
		int nID = Integer.parseInt(map.get("nID").toString());
		return notificationService.deleteNotification(uID, nID);
	}
}
