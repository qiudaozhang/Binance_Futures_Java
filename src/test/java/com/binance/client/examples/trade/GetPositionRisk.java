package com.binance.client.examples.trade;

import com.binance.client.RequestOptions;
import com.binance.client.SyncRequestClient;

import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.model.trade.PositionRisk;

import java.util.List;

public class GetPositionRisk {
    public static void main(String[] args) {
        RequestOptions options = new RequestOptions();
//        SyncRequestClient syncRequestClient = SyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY,
//                options);
        SyncRequestClient syncRequestClient = SyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY,
                "127.0.0.1",9981);
        List<PositionRisk> risks = syncRequestClient.getPositionRisk("ETHUSDT");

        for (PositionRisk risk:risks){
            System.out.println(risk);
        }
    }
}