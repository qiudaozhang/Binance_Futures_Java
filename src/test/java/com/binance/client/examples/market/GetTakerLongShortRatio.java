package com.binance.client.examples.market;

import com.binance.client.RequestOptions;
import com.binance.client.SyncRequestClient;
import com.binance.client.examples.ClientBuilder;
import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.model.enums.PeriodType;

public class GetTakerLongShortRatio {
    public static void main(String[] args) {
        RequestOptions options = new RequestOptions();
        SyncRequestClient client = ClientBuilder.proxyInstance();
        System.out.println(client.getTakerLongShortRatio("BTCUSDT", PeriodType._5m,null,null,10));


    }
}
