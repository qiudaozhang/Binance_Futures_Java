package com.binance.client.model.trade;

import com.binance.client.constant.BinanceApiConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;

public class AccountBalance {

    private String asset;

    private BigDecimal balance;

    private BigDecimal withdrawAvailable;

    private BigDecimal availableBalance;

    private BigDecimal maxWithdrawAmount;

    private BigDecimal crossWalletBalance;

    public BigDecimal getCrossWalletBalance() {
        return crossWalletBalance;
    }

    public void setCrossWalletBalance(BigDecimal crossWalletBalance) {
        this.crossWalletBalance = crossWalletBalance;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public BigDecimal getMaxWithdrawAmount() {
        return maxWithdrawAmount;
    }

    public void setMaxWithdrawAmount(BigDecimal maxWithdrawAmount) {
        this.maxWithdrawAmount = maxWithdrawAmount;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getWithdrawAvailable() {
        return withdrawAvailable;
    }

    public void setWithdrawAvailable(BigDecimal withdrawAvailable) {
        this.withdrawAvailable = withdrawAvailable;
    }

//    @Override
//    public String toString() {
//        return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE).append("asset", asset)
//                .append("balance", balance).append("withdrawAvailable", withdrawAvailable).toString();
//    }

    @Override
    public String toString() {
        return "AccountBalance{" +
                "asset='" + asset + '\'' +
                ", balance=" + balance +
                ", withdrawAvailable=" + withdrawAvailable +
                ", availableBalance=" + availableBalance +
                ", maxWithdrawAmount=" + maxWithdrawAmount +
                ", crossWalletBalance=" + crossWalletBalance +
                '}';
    }
}
