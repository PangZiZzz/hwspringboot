package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.HwUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author : Ghost
 * @className :  HwUserService
 * @packege :  com.example.service
 * @description :
 * @date :2021-09-10 13:21
 */
public interface HwUserService extends IService<HwUser> {
    //List<HwUser> selectHwUserByUserName(@Param("userName") String userName, @Param("userPwd") String userPwd);
}
