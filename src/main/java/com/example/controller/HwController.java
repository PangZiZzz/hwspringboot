package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.pojo.HwObj;
import com.example.pojo.HwSend;
import com.example.pojo.HwUser;
import com.example.service.HwObjService;
import com.example.service.HwSendService;
import com.example.service.HwUserService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : Ghost
 * @className :  HwController
 * @packege :  com.example.controller
 * @description :
 * @date :2021-09-10 13:27
 */
@RestController
@EnableScheduling   // 2.开启定时任务
public class HwController {

    @Resource
    private HwUserService hwUserService;
    @Resource
    private HwSendService hwSendService;
    @Resource
    private HwObjService hwObjService;

    //1.用户的注册
    @PostMapping("addHwUser")
    public Boolean addHwUser(HwUser hwUser) {
        //是否添加成功（false不成功，true成功）
        boolean save = false;
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name", hwUser.getUserName());
        List list = hwUserService.list(queryWrapper);
        //判断数据库中是否存在相同的用户名称，如果存在则返回false，不做添加操作，不存在则做添加操作
        if (list.size() == 0) {
            save = hwUserService.save(hwUser);
        }
        return save;
    }

    //2.用户的登录
    @PostMapping("selectOneByUserName")
    public boolean selectOneByUserName(HwUser hwUser) {
        //判断是否能找到用户，true：登录，false：不登录
        boolean flag = false;
        QueryWrapper<HwUser> queryWrapper = new QueryWrapper<HwUser>().eq("user_name", hwUser.getUserName());
        queryWrapper.and(i -> i.eq("user_pwd", hwUser.getUserPwd()));
        List<HwUser> list = hwUserService.list(queryWrapper);
        if (list.size() > 0) {
            flag = true;
        }
        //是否通过if
        System.out.println(flag);
        return flag;

    }

    //3.发送短信并且将数据添加到数据库中
    @PostMapping("send")

    public boolean send(HwSend hwSend) {
        return hwSendService.send(hwSend);
    }

    //4.通过userId查询Hw_Obj表中的数据
    @PostMapping("selectHwObjByUserId")
    public List<HwObj> selectHwObjByUserId(HwObj hwObj) {
        QueryWrapper<HwObj> queryWrapper = new QueryWrapper<HwObj>().eq("obj_isdel", 0);
        queryWrapper.eq("user_id", hwObj.getUserId());
        return hwObjService.list(queryWrapper);
    }

    //5.通过userId查询Hw_send表中的数据
    @PostMapping("selectHwSendByUserId")
    public List<HwSend> selectHwSendByUserId(HwSend hwSend) {
        QueryWrapper<HwSend> queryWrapper = new QueryWrapper<HwSend>().eq("send_isdel", 0);
        queryWrapper.eq("user_id", hwSend.getUserId());
        return hwSendService.list(queryWrapper);
    }

    //6.通过id查询Hw_user表中的数据
    @PostMapping("selectHwUserById")
    public List<HwUser> selectHwUserById(HwUser hwUser) {
        QueryWrapper<HwUser> queryWrapper = new QueryWrapper<HwUser>().eq("user_isdel", 0);
        queryWrapper.eq("id", hwUser.getId());
        return hwUserService.list(queryWrapper);
    }

    //7.查询Hw_obj整表
    @PostMapping("selectAllHwObj")
    public List<HwObj> selectAllHwObj() {
        return hwObjService.list();
    }

    //8.查询Hw_send整表
    @PostMapping("selectAllHwSend")
    public List<HwSend> selectAllHwSend() {
        return hwSendService.list();
    }

    //9.查询Hw_user整表
    @PostMapping("selectAllHwUser")
    public List<HwUser> selectAllHwUser() {
        return hwUserService.list();
    }

    //10.根据id来修改user_isdel
    @PostMapping("updateByIdHwUser")
    public boolean updateByIdHwUser(HwUser hwUser) {
        hwUser.setUserIsdel(1);
        return hwUserService.updateById(hwUser);
    }

    //11.根据id来修改obj_isdel
    @PostMapping("updateByIdHwObj")
    public boolean updateByIdHwObj(HwObj hwObj) {
        hwObj.setObjIsdel(1);
        return hwObjService.updateById(hwObj);
    }

    //12.根据id来修改obj_isdel
    @PostMapping("updateByIdHwSend")
    public boolean updateByIdHwSend(HwSend hwSend) {
        hwSend.setSendIsdel(1);
        return hwSendService.updateById(hwSend);
    }

    //13.根据id来修改HwUser
    @PostMapping("updateHwUser")
    public boolean updateHwUser(HwUser hwUser) {
        return hwUserService.updateById(hwUser);

    }

    //14.根据id来修改HwObj
    @PostMapping("updateHwHwObj")
    public boolean updateHwHwObj(HwObj hwObj) {
        return hwObjService.updateById(hwObj);
    }

    //15.根据id来修改HwUser
    @PostMapping("updateHwSend")
    public boolean updateHwSend(HwSend hwSend) {
        return hwSendService.updateById(hwSend);
    }
}
