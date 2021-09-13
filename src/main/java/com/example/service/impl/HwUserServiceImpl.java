package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.HwUserMapper;
import com.example.pojo.HwUser;
import com.example.service.HwUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Ghost
 * @className :  HwUserServiceImpl
 * @packege :  com.example.service.impl
 * @description :
 * @date :2021-09-10 13:22
 */
@Service
public class HwUserServiceImpl extends ServiceImpl<HwUserMapper, HwUser> implements HwUserService {
    /*@Resource
    private HwUserMapper hwUserMapper;
    @Override
    public List<HwUser> selectHwUserByUserName(@Param("userName") String userName, @Param("userPwd") String userPwd) {
        return hwUserMapper.selectHwUserByUserName(userName,userPwd);
    }*/
}
