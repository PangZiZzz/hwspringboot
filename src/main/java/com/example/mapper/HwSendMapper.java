package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.HwSend;
import com.example.pojo.SysHwSendvo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : Ghost
 * @className :  HwSendMapper
 * @packege :  com.example.mapper
 * @description :
 * @date :2021-09-10 14:49
 */
@Mapper
public interface HwSendMapper extends BaseMapper<HwSend> {
    @Select("select * from hw_send JOIN hw_user on hw_send.user_id = hw_user.id")
    List<SysHwSendvo> sysHwSendAll();
}
