package com.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : Ghost
 * @className :  HwUser
 * @packege :  com.example.pojo
 * @description :
 * @date :2021-09-10 13:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HwUser {
    //用户id
    @TableId(type = IdType.AUTO)
    private Integer id;
    //用户姓名
    private String userName;
    //用户密码
    private String userPwd;
    //0:不删除，1:删除
    private Integer userIsdel;
}
