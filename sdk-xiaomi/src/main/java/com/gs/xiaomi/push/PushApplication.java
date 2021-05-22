package com.gs.xiaomi.push;

import com.xiaomi.xmpush.server.Constants;

//自己添加的
public class PushApplication {

    public static void main(String[] args)  {
        Constants.useOfficial();  //正式环境

//        Constants.useSandbox(); // 测试环境

        TestMessage testMessage = new TestMessage();

        try {
            testMessage.sendMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
