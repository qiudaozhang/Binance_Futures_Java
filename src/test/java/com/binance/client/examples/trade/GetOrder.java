package com.binance.client.examples.trade;

import com.binance.client.RequestOptions;
import com.binance.client.SyncRequestClient;

import com.binance.client.examples.ClientBuilder;
import com.binance.client.examples.constants.PrivateConfig;

public class GetOrder {
    public static void main(String[] args) {
        RequestOptions options = new RequestOptions();
        SyncRequestClient syncRequestClient = ClientBuilder.proxyInstance();
        System.out.println(syncRequestClient.getOrder("ETHUSDT", 8389765527816167589L, null));
    }
}