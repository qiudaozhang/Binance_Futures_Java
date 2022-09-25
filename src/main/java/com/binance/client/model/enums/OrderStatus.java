package com.binance.client.model.enums;

import com.binance.client.impl.utils.EnumLookup;

/**
 * 合约订单状态
 */
public enum OrderStatus {
  NEW("NEW"),
  CANCELED("CANCELED"),
  EXPIRED("EXPIRED"),
  PARTIALLY_FILLED("PARTIALLY_FILLED"),
  FILLED("FILLED"), // 成交主要是这个
  NEW_INSURANCE("NEW_INSURANCE"), // 风险保障基金(强平)
  NEW_ADL("NEW_ADL"), // 自动减仓序列(强平)
  UNKNOWN("unknown");

  private final String code;

  OrderStatus(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return code;
  }

  private static final EnumLookup<OrderStatus> lookup = new EnumLookup<>(OrderStatus.class);

  public static OrderStatus lookup(String name) {
    return lookup.lookup(name);
  }

}
