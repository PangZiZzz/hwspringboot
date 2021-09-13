package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.HwSendMapper;
import com.example.pojo.HwObj;
import com.example.pojo.HwSend;
import com.example.service.HwObjService;
import com.example.service.HwSendService;
import com.example.until.ParseJSON;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

import static com.example.until.Util.getWeather;
import static com.example.until.Util.sendSms;

/**
 * @author : Ghost
 * @className :  HwSendServiceImpl
 * @packege :  com.example.service.impl
 * @description :
 * @date :2021-09-10 14:52
 */
@Service
public class HwSendServiceImpl extends ServiceImpl<HwSendMapper, HwSend> implements HwSendService {

    @Resource
    private HwSendService hwSendService;

    @Resource
    private HwObjService hwObjService;


    @Override
    @Transactional
    public boolean send(HwSend hwSend) {
        //判断数据是否添加成功
        boolean isSend = false;
        boolean save = hwSendService.save(hwSend);
        //成功后，创建HwObj对象，并且将值赋给HwObj，失败则返回false跳出
        HwObj hwObj = new HwObj();
        //1.根据城市查看天气
        String json = getWeather(hwSend.getSendCity());
        //2.根据天气的JSON信息，解析出天气，温度区间，温馨提示
        ParseJSON obj = new ParseJSON(json);
        //天气信息
        hwObj.setObjWeather(obj.getWeather());
        //获取并组装温度区间
        Map<String, String> temp = obj.getTemp();
        String lowTemp = temp.get("low");
        String highTemp = temp.get("high");
        hwObj.setObjTemp(lowTemp + "-" + highTemp + "°");
        //获取指数
        Map<String, String> tips = obj.getTips();
        hwObj.setObjTips(tips.values().toArray()[0].toString());
        //获取用户id
        hwObj.setUserId(hwSend.getUserId());
        //获取城市
        hwObj.setObjCity(hwSend.getSendCity());
        //获取电话号码
        hwObj.setObjPhoneNumber(hwSend.getSendPhoneNumber());
        //获取姓名
        hwObj.setObjName(hwSend.getSendName());
        //获取删除状态
        hwObj.setObjIsdel(hwSend.getSendIsdel());
        //添加一条HwObj数据
        boolean save1 = hwObjService.save(hwObj);
        //判断是否将数据添加进Hw_Obj表中，添加成功则发送短信，
        //否则返回false且控制台打印System.out.println("添加失败！短信不发送");
        if (save1) {
            //发短信
            sendSms(hwObj);
            System.out.println("添加成功！短信已发送");
            isSend = true;
        } else {
            System.out.println("添加失败！短信不发送");
            isSend = false;
        }
//        System.out.println(isSend);
        return isSend;
    }

}
