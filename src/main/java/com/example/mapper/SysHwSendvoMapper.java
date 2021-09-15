package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.SysHwSendvo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : Ghost
 * @className :  SysHwSendvoMapper
 * @packege :  com.example.mapper
 * @description :
 * @date :2021-09-15 21:34
 */
@Mapper
public interface SysHwSendvoMapper  extends BaseMapper<SysHwSendvo> {
    @Select("select * from hw_send JOIN hw_user on hw_send.user_id = hw_user.id where hw_send.id = #{id}")
    List<SysHwSendvo> selectSysHwsendvoByid(@Param("id") Integer id);
}
