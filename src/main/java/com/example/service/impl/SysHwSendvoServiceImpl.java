package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.SysHwSendvoMapper;
import com.example.pojo.SysHwSendvo;
import com.example.service.SysHwSendvoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Ghost
 * @className :  SysHwSendvoServiceImpl
 * @packege :  com.example.service.impl
 * @description :
 * @date :2021-09-15 21:37
 */
@Service
public class SysHwSendvoServiceImpl extends ServiceImpl<SysHwSendvoMapper, SysHwSendvo> implements SysHwSendvoService {
    @Resource
    private SysHwSendvoMapper sysHwSendvoMapper;
    @Override
    public List<SysHwSendvo> selectSysHwsendvoByid(Integer id) {
        return sysHwSendvoMapper.selectSysHwsendvoByid(id);
    }
}
