package com.loukjltd.final_assessment_back.controller;

import com.loukjltd.final_assessment_back.entity.Mine;
import com.loukjltd.final_assessment_back.service.MineService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public int MineLogIn(@RequestBody Map<String, Object> map) {
		String uPhone = map.get("uPhone").toString();
		String uPassword = map.get("uPassword").toString();
/*
        int result = mineService.MineLogIn(uPhone, uPassword);
        System.out.println("MineController中登陆返回的代码为" + result);
        System.out.println("MineController中登陆返回的uPhone为" + uPhone);
        System.out.println("MineController中登陆返回的uPassword为" + uPassword);
*/
		return mineService.MineLogIn(uPhone, uPassword);
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
		String uPhone = map.get("uPhone").toString();
		String uPassword = map.get("uPassword").toString();
		String uNickName = map.get("uNickName").toString();
		String uMotto = map.get("uMotto").toString();
		int result = mineService.MineRegister(uPhone, uPassword, uNickName, uMotto);
		System.out.println("MineController中注册返回的代码为" + result);
		System.out.println("MineController中注册返回的uPhone为" + uPhone);
		System.out.println("MineController中注册返回的uPassword为" + uPassword);
		System.out.println("MineController中注册返回的uNickName为" + uNickName);
		System.out.println("MineController中注册返回的uMotto为" + uMotto);
		return mineService.MineRegister(uPhone, uPassword, uNickName, uMotto);
	}
}
