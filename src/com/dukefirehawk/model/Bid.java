package com.dukefirehawk.model;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Bid {
    private final StringProperty volume;
    private final StringProperty price;

    public Bid(String volume, String price) {

        this.volume = new SimpleStringProperty(volume);
        this.price = new SimpleStringProperty(price);
    }

    public String getVolume() {
        return volume.get();
    }

    public StringProperty volumeProperty() {
        return volume;
    }

    public void setVolume(String buyVolume) {
        this.volume.set(buyVolume);
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }

    public void setPrice(String buyPrice) {
        this.price.set(buyPrice);
    }


}
