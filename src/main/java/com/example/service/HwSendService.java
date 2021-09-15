package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.HwSend;
import com.example.pojo.SysHwSendvo;

import java.util.List;

/**
 * @author : Ghost
 * @className :  HwSendService
 * @packege :  com.example.service
 * @description :
 * @date :2021-09-10 14:50
 */
public interface HwSendService extends IService<HwSend> {
    List<SysHwSendvo> sysHwSendAll();


    boolean send(HwSend hwSend);
}

