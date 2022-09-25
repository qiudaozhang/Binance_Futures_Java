package com.binance.client.examples.user;

import com.binance.client.RequestOptions;
import com.binance.client.SubscriptionOptions;
import com.binance.client.SyncRequestClient;
import com.binance.client.SubscriptionClient;
import com.binance.client.examples.ClientBuilder;

public class SubscribeUserData {

    public static void main(String[] args) {

        RequestOptions options = new RequestOptions();
//        SyncRequestClient syncRequestClient = SyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY,
//                options);

        SyncRequestClient syncRequestClient = ClientBuilder.proxyInstance();
        // Start user data stream
        String listenKey = syncRequestClient.startUserDataStream();
        System.out.println("listenKey: " + listenKey);
        // Keep user data stream
//        syncRequestClient.keepUserDataStream(listenKey);
//        syncRequestClient.closeUserDataStream(listenKey);
        SubscriptionOptions subscriptionOptions = new SubscriptionOptions();
        subscriptionOptions.setPingInterval(6000);
        SubscriptionClient client = SubscriptionClient.create(subscriptionOptions);
        client.subscribeUserDataEvent(listenKey, data -> {
            System.out.println("数据");
            System.out.println(data);
        }, exception -> {
            System.out.println(exception.getMessage());
            System.out.println("有错误");
            System.out.println(exception.getStackTrace());
        });

    }

}