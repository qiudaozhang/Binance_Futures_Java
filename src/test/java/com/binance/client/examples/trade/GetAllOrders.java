package com.binance.client.examples.trade;

import com.binance.client.RequestOptions;
import com.binance.client.SyncRequestClient;

import com.binance.client.examples.ClientBuilder;
import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.model.trade.Order;

import java.util.List;

public class GetAllOrders {
    public static void main(String[] args) {
        SyncRequestClient syncRequestClient = ClientBuilder.proxyInstance();
        List<Order> orders = syncRequestClient.getAllOrders("ETHUSDT", null, null, null, 10);
        orders.forEach(System.out::println);
    }
}