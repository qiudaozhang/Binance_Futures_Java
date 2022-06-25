package com.binance.client.examples.trade;

import com.binance.client.RequestOptions;
import com.binance.client.SyncRequestClient;

import com.binance.client.examples.ClientBuilder;
import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.model.trade.AccountBalance;

import java.math.BigDecimal;
import java.util.List;

public class GetBalance {
    public static void main(String[] args) {
        SyncRequestClient syncRequestClient = ClientBuilder.proxyInstance();
        BigDecimal b = syncRequestClient.getAvailable("USDT");
        System.out.println(b);
//        List<AccountBalance> balance = syncRequestClient.getBalance();
//
//        for (AccountBalance ab : balance) {
//            System.out.println(ab);
//        }

    }
}