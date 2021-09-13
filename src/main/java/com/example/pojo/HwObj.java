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
 * @className :  HwObj
 * @packege :  com.example.pojo
 * @description :
 * @date :2021-09-10 13:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HwObj {
    //    主键自增
    @TableId(type = IdType.AUTO)
    private Integer id;
    //    用户id
    private Integer userId;
    //    展示需要发送对象的手机号码
    @TableField("obj_phoneNumber")
    private String objPhoneNumber;
    //    展示需要发送信息中给对方的昵称
    private String objName;
    //    展示需要发送信息中对方所在的城市（查询对方所在城市的天气）
    private String objCity;
    //    展示温度区间（xx-xx°）
    private String objTemp;
    //    展示天气情况（如多云，晴）
    private String objWeather;
    //    展示温馨提示（天气还可以，预计白天没有降水，适合参加户外活动，适当锻炼身体。）
    private String objTips;
    //    0:不删除，1:删除
    private Integer objIsdel;
}
