package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.HwSend;

/**
 * @author : Ghost
 * @className :  HwSendService
 * @packege :  com.example.service
 * @description :
 * @date :2021-09-10 14:50
 */
public interface HwSendService extends IService<HwSend> {


    boolean send(HwSend hwSend);
}

