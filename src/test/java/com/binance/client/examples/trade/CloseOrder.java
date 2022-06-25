package com.binance.client.examples.trade;

import com.binance.client.RequestOptions;
import com.binance.client.SyncRequestClient;
import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.model.enums.PositionSide;
import com.binance.client.model.trade.Order;
import com.binance.client.model.trade.PositionRisk;

import java.math.BigDecimal;
import java.util.List;

public class CloseOrder {
    public static void main(String[] args) {
        RequestOptions options = new RequestOptions();
//        SyncRequestClient syncRequestClient = SyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY,
//                options);
        SyncRequestClient syncRequestClient = SyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY,
                "127.0.0.1", 7890);
        List<PositionRisk> risks = syncRequestClient.getPositionRisk("ETHUSDT");

        BigDecimal quantity = new BigDecimal("0.01");
        Order order = syncRequestClient.closeMarketLong("ETHUSDT", quantity, null);
        System.out.println(order);

//        for (PositionRisk risk : risks) {
//            if (risk.getPositionAmt().compareTo(BigDecimal.ZERO) > 0) {
//                if (risk.getPositionSide().equalsIgnoreCase(PositionSide.LONG.toString())) {
//                    System.out.println("多单");
//                    BigDecimal positionAmt = risk.getPositionAmt();
//
//                    syncRequestClient.closeMarketLong("ETHUSDT", quantity, null);
//
//
//                }
//                System.out.println(risk);
//            }
//        }
    }
}