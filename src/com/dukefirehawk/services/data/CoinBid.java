package com.dukefirehawk.services.data;

public class CoinBid {
    public String price;
    public String amount;

    public String displayData() {
        return " Price: " + price + " Amount: " + amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
