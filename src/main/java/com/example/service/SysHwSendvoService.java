package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.SysHwSendvo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : Ghost
 * @className :  SysHwSendvoService
 * @packege :  com.example.service
 * @description :
 * @date :2021-09-15 21:36
 */
public interface SysHwSendvoService extends IService<SysHwSendvo> {
    List<SysHwSendvo> selectSysHwsendvoByid(@Param("id") Integer id);
}
