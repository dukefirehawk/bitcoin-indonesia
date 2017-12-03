package com.dukefirehawk.services.data;

public class CoinTrade {
    public String date;
    public String price;
    public String amount;
    public String tid;
    public String type;

    public String displayData() {

        return "Date: " + date + " Price: " + price + " Amount: " + amount
                + " Tid: " + tid + " Type: " + type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
