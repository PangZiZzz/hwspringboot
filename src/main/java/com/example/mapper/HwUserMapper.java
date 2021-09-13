package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.HwUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author : Ghost
 * @className :  HwUserMapper
 * @packege :  com.example.mapper
 * @description :
 * @date :2021-09-10 13:21
 */
@Mapper
public interface HwUserMapper extends BaseMapper<HwUser> {
//    @Select("select * from hw_user where hw_user.user_name=#{userName}' and hw_user.user_pwd=#{userPwd}")
//    List<HwUser> selectHwUserByUserName(@Param("userName") String userName,@Param("userPwd") String userPwd);
}
