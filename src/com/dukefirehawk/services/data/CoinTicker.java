package com.dukefirehawk.services.data;

public class CoinTicker {
    public String high;
    public String low;
    public String vol_btc;
    public String vol_idr;
    public String last;
    public String buy;
    public String sell;
    public Integer server_time;

    public String displayData() {
        return " High: " + high + " Low: " + low + " Vol_btc: " + vol_btc + " Vol_idr: " + vol_idr
                + " Last: " + last + " Buy: " + buy + " Sell: " + sell + " Server_time: " + server_time;
    }
}
