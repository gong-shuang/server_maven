package com.gs.huawei.push;


import com.gs.huawei.push.examples.SendNotifyMessage;
import com.gs.huawei.push.exception.HuaweiMesssagingException;

//自己添加的
public class PushApplication {

    public static void main(String[] args) {

        SendNotifyMessage send = new SendNotifyMessage(); //需要修改这个类中的 Token ，指定某个设备
        try {
            send.sendNotification();
        } catch (HuaweiMesssagingException e) {
            e.printStackTrace();
        }

    }
}
