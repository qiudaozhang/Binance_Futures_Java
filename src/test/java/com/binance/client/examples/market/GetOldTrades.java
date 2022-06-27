package com.binance.client.examples.market;

import com.binance.client.RequestOptions;
import com.binance.client.SyncRequestClient;

import com.binance.client.examples.ClientBuilder;
import com.binance.client.examples.constants.PrivateConfig;

public class GetOldTrades {
    public static void main(String[] args) {
        RequestOptions options = new RequestOptions();
        SyncRequestClient syncRequestClient = ClientBuilder.proxyInstance();
        System.out.println(syncRequestClient.getOldTrades("ETHUSDT", 5, null));
    }
}
