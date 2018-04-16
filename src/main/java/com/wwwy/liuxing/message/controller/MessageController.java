package com.wwwy.liuxing.message.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.wwwy.liuxing.message.httpApiDemo.IndustrySMS;
import com.wwwy.liuxing.message.util.RandomNumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2018/4/13.
 */
@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private IndustrySMS industrySMS;

    /**
     * 填写手机号，获取验证码
     *
     * @param telephone
     * @param model
     * @return
     */
    @RequestMapping(value = "/getCode", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getRand(String telephone, HttpServletRequest request, ModelAndView model) {
        String randNum = RandomNumUtil.getRand();
        String json = industrySMS.execute(telephone, randNum);
        JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
        String respCode = obj.get("respCode").getAsString();
        if (respCode.equals("00000")) {
            return "{\"code\":\"1\",\"msg\":\"验证码发送成功\"}";
        } else if (respCode.equals("00126")) {
            return "{\"code\":\"0\",\"msg\":\"手机号格式不正确\"}";
        } else {
            return "{\"code\":\"0\",\"msg\":\"状态错误\"}";
        }
    }

    @RequestMapping(value = "/login", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String login(String inputCode) {
        String randNum = RandomNumUtil.num;
        System.out.println("randNum======" + randNum);
        System.out.println("inputCode====" + inputCode);
        if (randNum.equals(inputCode)) {
            return "订单提交成功";
        } else {
            return "订单提交失败";
        }
    }
}