package com.loukjltd.final_assessment_back.service;

import com.loukjltd.final_assessment_back.entity.Notification;
import com.loukjltd.final_assessment_back.mapper.NotificationMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
	private final NotificationMapper notificationMapper;
	
	public NotificationService(NotificationMapper notificationMapper) {
		this.notificationMapper = notificationMapper;
	}
	
	public List<Notification> getNotificationList(int uID) {
		return notificationMapper.getNotificationList(uID);
	}
	
	public int deleteNotification(int uID, int nID) {
		notificationMapper.deleteNotification(uID, nID);
		return 100;
	}
}
