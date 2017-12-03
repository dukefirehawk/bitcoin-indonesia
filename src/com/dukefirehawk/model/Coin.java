package com.dukefirehawk.model;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Coin {

    private final StringProperty date;
    private final StringProperty price;
    private final StringProperty amount;
    private final StringProperty tid;
    private final StringProperty tradeType;

    public Coin(String date, String price, String amount, String tid, String tradeType) {
        this.date = new SimpleStringProperty(date);
        this.price = new SimpleStringProperty(price);
        this.amount = new SimpleStringProperty(amount);
        this.tid = new SimpleStringProperty(tid);
        this.tradeType = new SimpleStringProperty(tradeType);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getAmount() {
        return amount.get();
    }

    public StringProperty amountProperty() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount.set(amount);
    }

    public String getTid() {
        return tid.get();
    }

    public StringProperty tidProperty() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid.set(tid);
    }

    public String getTradeType() {
        return tradeType.get();
    }

    public StringProperty tradeTypeProperty() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType.set(tradeType);
    }

    /*
    private final IntegerProperty buyVolume;
    private final IntegerProperty sellVolume;
    private final DoubleProperty buyPrice;
    private final DoubleProperty sellPrice;
    private final LongProperty tradeVolume;
    private final DoubleProperty lastTradePrice;
    private final ObjectProperty<LocalDate> tradeTime;

    public Coin(int buyVolume, double buyPrice, int sellVolume, double sellPrice,
                long tradeVolume, double lastTradePrice, Date tradeTime) {

        this.buyVolume = new SimpleIntegerProperty(buyVolume);
        this.sellVolume = new SimpleIntegerProperty(sellVolume);
        this.tradeVolume = new SimpleLongProperty(tradeVolume);
        this.buyPrice = new SimpleDoubleProperty(buyPrice);
        this.sellPrice = new SimpleDoubleProperty(sellPrice);
        this.lastTradePrice = new SimpleDoubleProperty(lastTradePrice);
        this.tradeTime = new SimpleObjectProperty<LocalDate>(tradeTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }

    public Coin() {
        buyVolume = new SimpleIntegerProperty(0);
        sellVolume = new SimpleIntegerProperty(0);
        tradeVolume = new SimpleLongProperty(0);
        buyPrice = new SimpleDoubleProperty(0.00);
        sellPrice = new SimpleDoubleProperty(0.00);
        lastTradePrice = new SimpleDoubleProperty(0.00);
        this.tradeTime = new SimpleObjectProperty<LocalDate>(LocalDate.of(2017, 1, 1));
    }

    public int getBuyVolume() {
        return buyVolume.get();
    }

    public IntegerProperty buyVolumeProperty() {
        return buyVolume;
    }

    public void setBuyVolume(int buyVolume) {
        this.buyVolume.set(buyVolume);
    }

    public int getSellVolume() {
        return sellVolume.get();
    }

    public IntegerProperty sellVolumeProperty() {
        return sellVolume;
    }

    public void setSellVolume(int sellVolume) {
        this.sellVolume.set(sellVolume);
    }

    public double getBuyPrice() {
        return buyPrice.get();
    }

    public DoubleProperty buyPriceProperty() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice.set(buyPrice);
    }

    public double getSellPrice() {
        return sellPrice.get();
    }

    public DoubleProperty sellPriceProperty() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice.set(sellPrice);
    }

    public long getTradeVolume() {
        return tradeVolume.get();
    }

    public LongProperty tradeVolumeProperty() {
        return tradeVolume;
    }

    public void setTradeVolume(int tradeVolume) {
        this.tradeVolume.set(tradeVolume);
    }

    public double getLastTradePrice() {
        return lastTradePrice.get();
    }

    public DoubleProperty lastTradePriceProperty() {
        return lastTradePrice;
    }

    public void setLastTradePrice(double lastTradePrice) {
        this.lastTradePrice.set(lastTradePrice);
    }

    public LocalDate getTradeTime() {
        return tradeTime.get();
    }

    public ObjectProperty<LocalDate> tradeTimeProperty() {
        return tradeTime;
    }

    public void setTradeTime(LocalDate tradeTime) {
        this.tradeTime.set(tradeTime);
    }
    */
}
