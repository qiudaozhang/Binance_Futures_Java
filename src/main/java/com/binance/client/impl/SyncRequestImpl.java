package com.binance.client.impl;

import com.alibaba.fastjson.JSONObject;
import com.binance.client.SyncRequestClient;
import com.binance.client.model.ResponseResult;
import com.binance.client.model.enums.*;
import com.binance.client.model.market.*;
import com.binance.client.model.trade.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SyncRequestImpl implements SyncRequestClient {

    private final RestApiRequestImpl requestImpl;


    SyncRequestImpl(RestApiRequestImpl requestImpl) {
        this.requestImpl = requestImpl;
    }


    private boolean proxy() {
        return requestImpl.getProxyHost() != null;
    }

    @Override
    public ExchangeInformation getExchangeInformation() {
        if (proxy()) {
            return RestApiInvoker.callSync(requestImpl.getExchangeInformation());

        }
        return RestApiInvoker.callSync(requestImpl.getExchangeInformation());
    }

    @Override
    public OrderBook getOrderBook(String symbol, Integer limit) {
        return RestApiInvoker.callSync(requestImpl.getOrderBook(symbol, limit));
    }

    @Override
    public List<Trade> getRecentTrades(String symbol, Integer limit) {
        return RestApiInvoker.callSync(requestImpl.getRecentTrades(symbol, limit));
    }

    @Override
    public List<Trade> getOldTrades(String symbol, Integer limit, Long fromId) {
        return RestApiInvoker.callSync(requestImpl.getOldTrades(symbol, limit, fromId));
    }

    @Override
    public List<AggregateTrade> getAggregateTrades(String symbol, Long fromId, Long startTime, Long endTime, Integer limit) {
        return RestApiInvoker.callSync(requestImpl.getAggregateTrades(symbol, fromId, startTime, endTime, limit));
    }

    @Override
    public List<Candlestick> getCandlestick(String symbol, CandlestickInterval interval, Long startTime, Long endTime, Integer limit) {
        return RestApiInvoker.callSync(requestImpl.getCandlestick(symbol, interval, startTime, endTime, limit));
    }


    @Override
    public List<MarkPrice> getMarkPrice(String symbol) {
        return RestApiInvoker.callSync(requestImpl.getMarkPrice(symbol));
    }

    @Override
    public List<FundingRate> getFundingRate(String symbol, Long startTime, Long endTime, Integer limit) {
        return RestApiInvoker.callSync(requestImpl.getFundingRate(symbol, startTime, endTime, limit));
    }

    @Override
    public List<PriceChangeTicker> get24hrTickerPriceChange(String symbol) {
        return RestApiInvoker.callSync(requestImpl.get24hrTickerPriceChange(symbol));
    }

    @Override
    public List<SymbolPrice> getSymbolPriceTicker(String symbol) {
        return RestApiInvoker.callSync(requestImpl.getSymbolPriceTicker(symbol));
    }

    @Override
    public List<SymbolOrderBook> getSymbolOrderBookTicker(String symbol) {
        return RestApiInvoker.callSync(requestImpl.getSymbolOrderBookTicker(symbol));
    }

    @Override
    public List<LiquidationOrder> getLiquidationOrders(String symbol, Long startTime, Long endTime, Integer limit) {
        return RestApiInvoker.callSync(requestImpl.getLiquidationOrders(symbol, startTime, endTime, limit));
    }

    @Override
    public List<Object> postBatchOrders(String batchOrders) {
        return RestApiInvoker.callSync(requestImpl.postBatchOrders(batchOrders));
    }

    @Override
    public Order postOrder(String symbol, OrderSide side, PositionSide positionSide, OrderType orderType, TimeInForce timeInForce, String quantity, String price, String reduceOnly, String newClientOrderId, String stopPrice, WorkingType workingType, NewOrderRespType newOrderRespType) {
        return RestApiInvoker.callSync(requestImpl.postOrder(symbol, side, positionSide, orderType, timeInForce, quantity, price, reduceOnly, newClientOrderId, stopPrice, workingType, newOrderRespType));
    }

    @Override
    public Order postOrder(String symbol, OrderSide side, PositionSide positionSide, OrderType orderType, TimeInForce timeInForce, String quantity, String price, String reduceOnly, String newClientOrderId, String stopPrice, WorkingType workingType, NewOrderRespType newOrderRespType, String closePosition) {
        return RestApiInvoker.callSync(requestImpl.postOrder(symbol, side, positionSide, orderType, timeInForce, quantity, price, reduceOnly, newClientOrderId, stopPrice, workingType, newOrderRespType,closePosition));
    }

    @Override
    public Order openMarket(String symbol, OrderSide side, PositionSide positionSide, BigDecimal margin, String newClientOrderId) {
        return postOrder(symbol, side, positionSide, OrderType.MARKET, null, margin.toString(), null, null, newClientOrderId, null, WorkingType.MARK_PRICE, NewOrderRespType.ACK);
    }

    @Override
    public Order openLimit(String symbol, OrderSide side, PositionSide positionSide, BigDecimal quantity, BigDecimal price, String newClientOrderId) {
        return postOrder(symbol, side, positionSide, OrderType.LIMIT, TimeInForce.GTC, quantity.toString(), price.toString(),
                null, newClientOrderId, null, WorkingType.MARK_PRICE, NewOrderRespType.ACK);
    }

    @Override
    public Order openLimitLong(String symbol, BigDecimal quantity, BigDecimal price, String newClientOrderId) {
        return openLimit(symbol, OrderSide.BUY, PositionSide.LONG, quantity, price, newClientOrderId);
    }

    @Override
    public Order closeLimitLong(String symbol, BigDecimal quantity, BigDecimal price, String newClientOrderId) {
        return openLimit(symbol, OrderSide.SELL, PositionSide.LONG, quantity, price, newClientOrderId);
    }

    @Override
    public Order openLimitShort(String symbol, BigDecimal quantity, BigDecimal price, String newClientOrderId) {
        return openLimit(symbol, OrderSide.SELL, PositionSide.SHORT, quantity, price, newClientOrderId);
    }

    @Override
    public Order closeLimitShort(String symbol, BigDecimal quantity, BigDecimal price, String newClientOrderId) {
        return openLimit(symbol, OrderSide.BUY, PositionSide.SHORT, quantity, price, newClientOrderId);
    }

    @Override
    public Order openDelegate(String symbol, OrderSide side, PositionSide positionSide, BigDecimal margin, BigDecimal price, BigDecimal stopPrice, String newClientOrderId) {
        return postOrder(symbol, side, positionSide, OrderType.TAKE_PROFIT, null, margin.toString(), price.toString(), null, newClientOrderId,
                stopPrice.toString(), WorkingType.MARK_PRICE, NewOrderRespType.ACK);
    }

    @Override
    public Order openDelegateLong(String symbol, BigDecimal margin, BigDecimal price, BigDecimal stopPrice, String newClientOrderId) {
        return openDelegate(symbol, OrderSide.BUY, PositionSide.LONG, margin, price, stopPrice, newClientOrderId);
    }

    @Override
    public Order openDelegateShort(String symbol, BigDecimal margin, BigDecimal price, BigDecimal stopPrice, String newClientOrderId) {
        return openDelegate(symbol, OrderSide.SELL, PositionSide.SHORT, margin, price, stopPrice, newClientOrderId);
    }

    @Override
    public Order openMarketLong(String symbol, BigDecimal quantity, String newClientOrderId) {
        return openMarket(symbol, OrderSide.BUY, PositionSide.LONG, quantity, newClientOrderId);
    }

    @Override
    public Order openLongProfitMarket(String symbol, BigDecimal quantity, BigDecimal price, String newClientOrderId) {
        return postOrder(symbol, OrderSide.SELL, PositionSide.LONG, OrderType.TAKE_PROFIT_MARKET, null,quantity.toString(), null, null, newClientOrderId, price.toString(), WorkingType.MARK_PRICE, NewOrderRespType.ACK);
    }

    @Override
    public Order openLongProfitMarketAll(String symbol, BigDecimal price, String newClientOrderId) {
        return postOrder(symbol, OrderSide.SELL, PositionSide.LONG, OrderType.TAKE_PROFIT_MARKET, null,null, null, null, newClientOrderId, price.toString(), WorkingType.MARK_PRICE, NewOrderRespType.ACK,"true");
    }

    @Override
    public Order openShortProfitMarket(String symbol, BigDecimal quantity, BigDecimal price, String newClientOrderId) {
        return postOrder(symbol, OrderSide.BUY, PositionSide.SHORT, OrderType.TAKE_PROFIT_MARKET, null,quantity.toString(), null, null, newClientOrderId, price.toString(), WorkingType.MARK_PRICE, NewOrderRespType.ACK);
    }

    @Override
    public Order openShortProfitMarketAll(String symbol, BigDecimal price, String newClientOrderId) {
        return postOrder(symbol, OrderSide.BUY, PositionSide.SHORT, OrderType.TAKE_PROFIT_MARKET, null,null, null, null, newClientOrderId, price.toString(), WorkingType.MARK_PRICE, NewOrderRespType.ACK,"true");
    }

    @Override
    public Order openLongStopMarket(String symbol, BigDecimal quantity, BigDecimal price, String newClientOrderId) {
        return postOrder(symbol, OrderSide.SELL, PositionSide.LONG, OrderType.STOP_MARKET, null,quantity.toString(), null, null, newClientOrderId, price.toString(), WorkingType.MARK_PRICE, NewOrderRespType.ACK);
    }

    @Override
    public Order openLongStopMarketAll(String symbol, BigDecimal price, String newClientOrderId) {
        return postOrder(symbol, OrderSide.SELL, PositionSide.LONG, OrderType.STOP_MARKET, null,null, null, null, newClientOrderId, price.toString(), WorkingType.MARK_PRICE, NewOrderRespType.ACK,"true");
    }

    @Override
    public Order openShortStopMarket(String symbol, BigDecimal quantity, BigDecimal price, String newClientOrderId) {
        return postOrder(symbol, OrderSide.BUY, PositionSide.SHORT, OrderType.STOP_MARKET, null,quantity.toString(), null, null, newClientOrderId, price.toString(), WorkingType.MARK_PRICE, NewOrderRespType.ACK);
    }

    @Override
    public Order openShortStopMarketAll(String symbol, BigDecimal price, String newClientOrderId) {
        return postOrder(symbol, OrderSide.BUY, PositionSide.SHORT, OrderType.STOP_MARKET, null,null, null, null, newClientOrderId, price.toString(), WorkingType.MARK_PRICE, NewOrderRespType.ACK,"true");
    }

    @Override
    public Order openMarketShort(String symbol, BigDecimal quantity, String newClientOrderId) {
        return openMarket(symbol, OrderSide.SELL, PositionSide.SHORT, quantity, newClientOrderId);
    }

    @Override
    public Order closeMarketLong(String symbol, BigDecimal quantity, String newClientOrderId) {

        List<PositionRisk> positionRisk = getPositionRisk(symbol);
        Optional<PositionRisk> op = positionRisk.stream().filter(c -> c.getPositionSide().equalsIgnoreCase(PositionSide.LONG.toString())).findFirst();
        if (op.isPresent()) {
            PositionRisk risk = op.get();
            if (risk.getPositionAmt().compareTo(quantity) < 0) {
                return null;
            } else {
                return postOrder(symbol, OrderSide.SELL, PositionSide.LONG, OrderType.MARKET, null, quantity.toString(), null, null, newClientOrderId, null, WorkingType.MARK_PRICE, NewOrderRespType.ACK);
            }
        } else {
            return null;
        }
    }

    @Override
    public Order closeMarketShort(String symbol, BigDecimal quantity, String newClientOrderId) {
        return postOrder(symbol, OrderSide.BUY, PositionSide.SHORT, OrderType.MARKET, null, quantity.toString(), null, null, newClientOrderId, null, WorkingType.MARK_PRICE, NewOrderRespType.ACK);
    }

    @Override
    public Order closeOrder(String symbol, BigDecimal quantity) {
        return null;
    }

    @Override
    public Order cancelOrder(String symbol, Long orderId, String origClientOrderId) {
        return RestApiInvoker.callSync(requestImpl.cancelOrder(symbol, orderId, origClientOrderId));
    }

    @Override
    public ResponseResult cancelAllOpenOrder(String symbol) {
        return RestApiInvoker.callSync(requestImpl.cancelAllOpenOrder(symbol));
    }

    @Override
    public List<Object> batchCancelOrders(String symbol, String orderIdList, String origClientOrderIdList) {
        return RestApiInvoker.callSync(requestImpl.batchCancelOrders(symbol, orderIdList, origClientOrderIdList));
    }

    @Override
    public ResponseResult changePositionSide(boolean dual) {
        return RestApiInvoker.callSync(requestImpl.changePositionSide(dual));
    }

    @Override
    public ResponseResult changeMarginType(String symbolName, String marginType) {
        return RestApiInvoker.callSync(requestImpl.changeMarginType(symbolName, marginType));
    }

    @Override
    public JSONObject addIsolatedPositionMargin(String symbolName, int type, String amount, PositionSide positionSide) {
        return RestApiInvoker.callSync(requestImpl.addPositionMargin(symbolName, type, amount, positionSide));
    }

    @Override
    public List<WalletDeltaLog> getPositionMarginHistory(String symbolName, int type, long startTime, long endTime, int limit) {
        return RestApiInvoker.callSync(requestImpl.getPositionMarginHistory(symbolName, type, startTime, endTime, limit));
    }


    @Override
    public JSONObject getPositionSide() {
        return RestApiInvoker.callSync(requestImpl.getPositionSide());
    }

    @Override
    public Order getOrder(String symbol, Long orderId, String origClientOrderId) {
        return RestApiInvoker.callSync(requestImpl.getOrder(symbol, orderId, origClientOrderId));
    }

    @Override
    public List<Order> getOpenOrders(String symbol) {
        return RestApiInvoker.callSync(requestImpl.getOpenOrders(symbol));
    }

    @Override
    public List<Order> getAllOrders(String symbol, Long orderId, Long startTime, Long endTime, Integer limit) {
        return RestApiInvoker.callSync(requestImpl.getAllOrders(symbol, orderId, startTime, endTime, limit));
    }

    @Override
    public List<AccountBalance> getBalance() {
        return RestApiInvoker.callSync(requestImpl.getBalance());
    }

    @Override
    public BigDecimal getAvailable(String symbol) {
        List<AccountBalance> balance = getBalance();
        Optional<AccountBalance> op = balance.stream().filter(c -> c.getAsset().equalsIgnoreCase(symbol)).findFirst();
        if (op.isPresent()) {
            return op.get().getAvailableBalance();
        } else {
            return BigDecimal.ZERO;
        }
    }

    @Override
    public AccountInformation getAccountInformation() {
        return RestApiInvoker.callSync(requestImpl.getAccountInformation());
    }

    @Override
    public Leverage changeInitialLeverage(String symbol, Integer leverage) {
        return RestApiInvoker.callSync(requestImpl.changeInitialLeverage(symbol, leverage));
    }



    @Override
    public List<PositionRisk> getPositionRisk() {
        return RestApiInvoker.callSync(requestImpl.getPositionRisk());
    }

    @Override
    public List<PositionRisk> getPositionRisk(String symbol) {
        return RestApiInvoker.callSync(requestImpl.getPositionRisk(symbol));
    }

    @Override
    public PositionRisk getPositionRiskOne(String symbol, PositionSide side) {
        List<PositionRisk> data = RestApiInvoker.callSync(requestImpl.getPositionRisk(symbol));
        Optional<PositionRisk> op = data.stream().filter(d -> d.getPositionSide().equals(side.toString())).findFirst();
        return op.orElse(null);
    }

    @Override
    public List<PositionRisk> getRunPositionRisk(String symbol) {
        return getPositionRisk(symbol).stream().filter(c->c.getPositionAmt().compareTo(BigDecimal.ZERO) != 0).collect(Collectors.toList());
    }


    @Override
    public List<MyTrade> getAccountTrades(String symbol, Long startTime, Long endTime, Long fromId, Integer limit) {
        return RestApiInvoker.callSync(requestImpl.getAccountTrades(symbol, startTime, endTime, fromId, limit));
    }

    @Override
    public List<Income> getIncomeHistory(String symbol, IncomeType incomeType, Long startTime, Long endTime, Integer limit) {
        return RestApiInvoker.callSync(requestImpl.getIncomeHistory(symbol, incomeType, startTime, endTime, limit));
    }

    @Override
    public String startUserDataStream() {
        return RestApiInvoker.callSync(requestImpl.startUserDataStream());
    }

    @Override
    public String keepUserDataStream(String listenKey) {
        return RestApiInvoker.callSync(requestImpl.keepUserDataStream(listenKey));
    }

    @Override
    public String closeUserDataStream(String listenKey) {
        return RestApiInvoker.callSync(requestImpl.closeUserDataStream(listenKey));
    }

    @Override
    public List<OpenInterestStat> getOpenInterestStat(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit) {
        return RestApiInvoker.callSync(requestImpl.getOpenInterestStat(symbol, period, startTime, endTime, limit));
    }

    @Override
    public List<CommonLongShortRatio> getTopTraderAccountRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit) {
        return RestApiInvoker.callSync(requestImpl.getTopTraderAccountRatio(symbol, period, startTime, endTime, limit));
    }

    @Override
    public List<CommonLongShortRatio> getTopTraderPositionRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit) {
        return RestApiInvoker.callSync(requestImpl.getTopTraderPositionRatio(symbol, period, startTime, endTime, limit));
    }

    @Override
    public List<CommonLongShortRatio> getGlobalAccountRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit) {
        return RestApiInvoker.callSync(requestImpl.getGlobalAccountRatio(symbol, period, startTime, endTime, limit));
    }

    @Override
    public List<TakerLongShortStat> getTakerLongShortRatio(String symbol, PeriodType period, Long startTime, Long endTime, Integer limit) {
        return RestApiInvoker.callSync(requestImpl.getTakerLongShortRatio(symbol, period, startTime, endTime, limit));
    }
}
