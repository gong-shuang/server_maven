/*
 * Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package com.gs.huawei.push.examples;

import com.alibaba.fastjson.JSONObject;
import com.gs.huawei.push.exception.HuaweiMesssagingException;
import com.gs.huawei.push.messaging.HuaweiApp;
import com.gs.huawei.push.messaging.HuaweiMessaging;
import com.gs.huawei.push.android.AndroidNotification;
import com.gs.huawei.push.android.BadgeNotification;
import com.gs.huawei.push.android.Button;
import com.gs.huawei.push.android.ClickAction;
import com.gs.huawei.push.android.Color;
import com.gs.huawei.push.android.LightSettings;
import com.gs.huawei.push.message.AndroidConfig;
import com.gs.huawei.push.message.Message;
import com.gs.huawei.push.message.Notification;
import com.gs.huawei.push.model.Urgency;
import com.gs.huawei.push.model.Importance;
import com.gs.huawei.push.model.Visibility;
import com.gs.huawei.push.reponse.SendResponse;
import com.gs.huawei.push.util.InitAppUtils;

public class SendNotifyMessage {
    /**
     * send notification message
     *
     * @throws HuaweiMesssagingException
     */
    public void sendNotification() throws HuaweiMesssagingException {
        HuaweiApp app = InitAppUtils.initializeApp();
        HuaweiMessaging huaweiMessaging = HuaweiMessaging.getInstance(app);

        Notification notification = Notification.builder().setTitle("sample title")
                .setBody("sample message body")
                .build();

        JSONObject multiLangKey = new JSONObject();
        JSONObject titleKey = new JSONObject();
        titleKey.put("en","????????????");
        JSONObject bodyKey = new JSONObject();
        titleKey.put("en","My name is %s, I am from %s.");
        multiLangKey.put("key1", titleKey);
        multiLangKey.put("key2", bodyKey);

        LightSettings lightSettings = LightSettings.builder().setColor(Color.builder().setAlpha(0f).setRed(0f).setBlue(1f).setGreen(1f).build())
                .setLightOnDuration("3.5")
                .setLightOffDuration("5S")
                .build();

        AndroidNotification androidNotification = AndroidNotification.builder().setIcon("/raw/ic_launcher2")
                .setColor("#AACCDD")
                .setSound("/raw/shake")
                .setDefaultSound(true)
                .setTag("tagBoom77777777777")
                .setClickAction(ClickAction.builder().setType(2).setUrl("https://www.huawei.com").build())
                .setBodyLocKey("M.String.body")
                .addBodyLocArgs("boy").addBodyLocArgs("dog")
                .setTitleLocKey("M.String.title")
                .addTitleLocArgs("Girl").addTitleLocArgs("Cat")
                .setChannelId("Your Channel ID")
                .setNotifySummary("some summary")
                .setMultiLangkey(multiLangKey)
                .setStyle(1)
                .setBigTitle("Big Boom Title")
                .setBigBody("Big Boom Body")
                .setAutoClear(86400000)
                .setNotifyId(486)
                .setGroup("Group1")
                .setImportance(Importance.LOW.getValue())
                .setLightSettings(lightSettings)
                .setBadge(BadgeNotification.builder().setAddNum(1).setBadgeClass("Classic").build())
                .setVisibility(Visibility.PUBLIC.getValue())
                .setForegroundShow(true)
                .addInboxContent("content1").addInboxContent("content2").addInboxContent("content3").addInboxContent("content4").addInboxContent("content5")
                .addButton(Button.builder().setName("button1").setActionType(0).build())
                .addButton(Button.builder().setName("button2").setActionType(1).setIntentType(0).setIntent("https://com.huawei.hms.hmsdemo/deeplink").build())
                .addButton(Button.builder().setName("button3").setActionType(4).setData("your share link").build())
                .build();

        AndroidConfig androidConfig = AndroidConfig.builder().setCollapseKey(-1)
                .setUrgency(Urgency.HIGH.getValue())
                .setTtl("10000s")
                .setBiTag("the_sample_bi_tag_for_receipt_service")
                .setNotification(androidNotification)
                .build();

        Message message = Message.builder().setNotification(notification)
                .setAndroidConfig(androidConfig)
                .addToken("0866774043149148300008665100CN01")
                .build();

        SendResponse response = huaweiMessaging.sendMessage(message);
        System.out.printf("response:" + response.toString());
    }
}
