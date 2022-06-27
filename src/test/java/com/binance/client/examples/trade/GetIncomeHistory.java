package com.binance.client.examples.trade;

import com.binance.client.RequestOptions;
import com.binance.client.SyncRequestClient;

import com.binance.client.examples.ClientBuilder;
import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.model.trade.Income;

import java.util.List;

public class GetIncomeHistory {
    public static void main(String[] args) {
        RequestOptions options = new RequestOptions();
        SyncRequestClient syncRequestClient = ClientBuilder.proxyInstance();
        List<Income> incomes = syncRequestClient.getIncomeHistory("ETHUSDT", null, 1656300032921L-1000L, null, 5);

        for (Income income:incomes){
            System.out.println(income);
        }
    }
}