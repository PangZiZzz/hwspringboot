package com.example.until;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.pojo.HwObj;
import com.example.pojo.HwSend;
import com.example.service.HwObjService;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author : Ghost
 * @className :  Util
 * @packege :  com.kkb.until
 * @description :
 * @date :2021-09-09 15:00
 */
public class Util {
    /*
     * 读取网址数据
     */
    private static String getString(String url) {
        //1.创建一个网址的 抽象表示（对象）
        try {
            URL u = new URL(url);
            //2.打开链接
            URLConnection urlConnection = u.openConnection();
            //3.获取传输数据的通道（字节输入流）
            InputStream is = urlConnection.getInputStream();
            //4.将字节输入流，转换为能一次读取一行的缓冲字符输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            //5.读取一行行的数据，并汇总
            StringBuffer sb = new StringBuffer();
            String text = null;
            while ((text = br.readLine()) != null) {
                sb.append(text);
            }
            //6.将读取的数据返回给调用者
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * 查询天气
     * @param city 要查询的城市
     * @return 天气结果
     * */
    public static String getWeather(String city) {
        try {
            String json = getString("https://itdage.cn/hw/weather?city=" + URLEncoder.encode(city, "UTF-8"));
            return json;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String sendSms(HwObj hwObj) {
        try {
            hwObj.setObjName(URLEncoder.encode(hwObj.getObjName(), "UTF-8"));
            hwObj.setObjWeather(URLEncoder.encode(hwObj.getObjWeather(), "UTF-8"));
            hwObj.setObjTemp(URLEncoder.encode(hwObj.getObjTemp(), "UTF-8"));
            hwObj.setObjTips(URLEncoder.encode(hwObj.getObjTips(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String json = getString("https://itdage.cn/hw/hwSms?name=" + hwObj.getObjName() + "&phoneNumber="
                + hwObj.getObjPhoneNumber() + "&s1=" + hwObj.getObjWeather() + "&s2=" + hwObj.getObjTemp()
                + "&s3=" + hwObj.getObjTips());
        System.out.println(json);
        return json;
    }
    /*@Resource
    private HwObjService hwObjService;
    public boolean send(HwSend hwSend) {

    }*/
}
