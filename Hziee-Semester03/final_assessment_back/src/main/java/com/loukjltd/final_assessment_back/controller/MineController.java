package com.loukjltd.final_assessment_back.controller;

import com.loukjltd.final_assessment_back.entity.Mine;
import com.loukjltd.final_assessment_back.service.MineService;
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
public class MineController {
	private final MineService mineService;
	
	public MineController(MineService mineService) {
		this.mineService = mineService;
	}
	
	@RequestMapping("Mine")
	@ResponseBody
	public List<Mine> getMine() {
		return mineService.getMineList();
	}
	
	@RequestMapping("MineLogIn")
	@ResponseBody
	public int MineLogIn(@RequestBody Map<String, Object> map) throws ParseException {
		String uPhone = map.get("uPhone").toString();
		String uPassword = map.get("uPassword").toString();
		int adminFlag = Integer.parseInt(map.get("adminFlag").toString());
		String dateFormat = "yyyy/MM/dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		String uLastLoggedTime = map.get("uLastLoggedTime").toString();
		Date convertedTime = sdf.parse(uLastLoggedTime);
		return mineService.MineLogIn(uPhone, uPassword, adminFlag, convertedTime);
	}
	
	@RequestMapping("MineLogOut")
	@ResponseBody
	public void MineLogOut(@RequestBody Map<String, Object> map) {
		String uNickName = map.get("uNickName").toString();
		mineService.MineLogOut(uNickName);
	}
	
	@RequestMapping("MineRegister")
	@ResponseBody
	public int MineRegister(@RequestBody Map<String, Object> map) {
		int uID = Integer.parseInt(map.get("uID").toString());
		String uPhone = map.get("uPhone").toString();
		String uPassword = map.get("uPassword").toString();
		String uNickName = map.get("uNickName").toString();
		String uMotto = map.get("uMotto").toString();
		String uAvatar = map.get("uAvatar").toString();
		return mineService.MineRegister(uID, uPhone, uPassword, uNickName, uMotto, uAvatar);
	}
	
	@RequestMapping("MineEverydaySignIn")
	@ResponseBody
	public void MineEverydaySignIn(@RequestBody Map<String, Object> map) {
		int uID = Integer.parseInt(map.get("uID").toString());
		mineService.MineEverydaySignIn(uID);
	}
	
	@RequestMapping("InsertRelatedTaskWithNewUser")
	@ResponseBody
	public void InsertRelatedTaskWithNewUser(@RequestBody Map<String, Object> map) {
		int uID = Integer.parseInt(map.get("uID").toString());
		mineService.InsertRelatedTaskWithNewUser(uID);
	}
}
