package com.binance.client.examples.trade;

import com.binance.client.SyncRequestClient;
import com.binance.client.examples.ClientBuilder;

/**
 * @author : wangwanlu
 * @since : 2020/4/7, Tue
 **/
public class GetLeverage {

    public static void main(String[] args) {
        SyncRequestClient syncRequestClient = ClientBuilder.proxyInstance();
        System.out.println(syncRequestClient.getLeverage("ETHUSDT"));
    }
}
