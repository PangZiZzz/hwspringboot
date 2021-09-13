package com.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : Ghost
 * @className :  HwSend
 * @packege :  com.example.pojo
 * @description :
 * @date :2021-09-10 14:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HwSend {
    //    主键自增
    @TableId(type = IdType.AUTO)
    private Integer id;
    //    用户id
    private Integer userId;
    //    需要发送信息中给对方的昵称
    private String sendName;
    //    需要发送对象的手机号码
    @TableField("send_phoneNumber")
    private String sendPhoneNumber;
    //    需要发送信息中对方所在的城市（查询对方所在城市的天气）
    private String sendCity;
    //    0:不删除，1:删除
    private Integer sendIsdel;
}
