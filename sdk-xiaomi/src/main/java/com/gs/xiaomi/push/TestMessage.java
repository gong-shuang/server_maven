package com.gs.xiaomi.push;

import com.xiaomi.xmpush.server.Constants;
import com.xiaomi.xmpush.server.Message;
import com.xiaomi.xmpush.server.Result;
import com.xiaomi.xmpush.server.Sender;


public class TestMessage {

    //每个设备的 regid 都不一样
    private String regId = "E7WUog8it9oI0QIjS3t9zcBWotNf5aOobich3HmYRMJOtYii/T2D5y8dpb5LtK/V";

    public void sendMessage() throws Exception {
        Constants.useOfficial();
        Sender sender = new Sender(com.gs.xiaomi.push.Constants.APP_SECRET_KEY);
        String messagePayload = "This is a message";
        String title = "notification title";
        String description = "notification description";
        Message message = new Message.Builder()
                .title(title)
                .description(description).payload(messagePayload)
                .restrictedPackageName(com.gs.xiaomi.push.Constants.MY_PACKAGE_NAME)
                .notifyType(1)     // 使用默认提示音提示
                .build();
        Result result = sender.send(message, regId, 3);
        System.out.println("Server response: " + "MessageId: " + result.getMessageId()
                + " ErrorCode: " + result.getErrorCode().toString()
                + " Reason: " + result.getReason());
    }
}
