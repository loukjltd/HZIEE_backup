package com.loukjltd.final_assessment_back.service;

import com.loukjltd.final_assessment_back.entity.Mine;
import com.loukjltd.final_assessment_back.mapper.MineMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MineService {
	private final MineMapper mineMapper;
	
	public MineService(MineMapper mineMapper) {
		this.mineMapper = mineMapper;
	}
	
	public List<Mine> getMineList() {
		return mineMapper.getMineList();
	}
	
	public int MineLogIn(String uPhone, String uPassword) {
		List<Mine> mineList = mineMapper.getMineList();
		int logResultCode = 144; // 表示登陆失败的代码
		for (Mine mine : mineList) {
			if (uPhone.isEmpty() || uPassword.isEmpty()) {
				logResultCode = 122; // 表示输入框为空的代码
				break;
			} else if (mine.getuPhone().equals(uPhone) && mine.getuPassword().equals(uPassword)) {
				mineMapper.updateStatusToIn(uPhone);
				logResultCode = 100; // 表示登陆成功的代码
				break;
			}
		}
//        System.out.println("MineService中登陆返回的代码为" + logResultCode);
		return logResultCode;
	}
	
	public void MineLogOut(String uNickName) {
		mineMapper.updateStatusToOut(uNickName);
	}
}
