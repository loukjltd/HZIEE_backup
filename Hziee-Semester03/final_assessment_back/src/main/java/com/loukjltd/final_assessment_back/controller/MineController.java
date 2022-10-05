package com.loukjltd.final_assessment_back.controller;

import com.loukjltd.final_assessment_back.entity.Mine;
import com.loukjltd.final_assessment_back.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private MineService mineService;

    @RequestMapping("Mine")
    @ResponseBody
    public List<Mine> getMine() {
        return mineService.getMineList();
    }

    @RequestMapping("MineLogIn")
    @ResponseBody
    public void MineLogIn(@RequestBody Map<String, Object> map) {
        String uPhone = map.get("uPhone").toString();
        mineService.MineLogIn(uPhone);
    }

    @RequestMapping("MineLogOut")
    @ResponseBody
    public void MineLogOut(@RequestBody Map<String, Object> map) {
        String uNickName = map.get("uNickName").toString();
//        int uIfLogged = Integer.parseInt(map.get("uIfLogged").toString());
        mineService.MineLogOut(uNickName);
    }
}
