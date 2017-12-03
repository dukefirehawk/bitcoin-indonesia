package com.dukefirehawk.services;

import com.dukefirehawk.services.data.CoinDept;
import com.dukefirehawk.services.data.CoinTrade;
import com.dukefirehawk.services.data.TradeTicker;
import com.jsoniter.JsonIterator;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataService {

    private static String BTC_TICKER_URL = "https://vip.bitcoin.co.id/api/btc_idr/ticker";
    private static String BTC_TRADE_URL = "https://vip.bitcoin.co.id/api/btc_idr/trades";
    private static String BTC_DEPT_URL = "https://vip.bitcoin.co.id/api/btc_idr/depth";

    public List<CoinTrade> extractTradeData() {

        URL obj = null;
        InputStream in = null;
        BufferedInputStream buffIn = null;

        try {
            obj = new URL(BTC_TRADE_URL);
            HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
            in = conn.getInputStream();
            buffIn = new BufferedInputStream(in);

            byte[] data      = new byte[512];
            int bytesRead = -1;

            ByteArrayOutputStream memOut = new ByteArrayOutputStream();
            while((bytesRead = buffIn.read(data)) != -1) {
                memOut.write(data, 0, bytesRead);
             }
            memOut.close();

            CoinTrade[] bidList = JsonIterator.deserialize(memOut.toByteArray(), CoinTrade[].class);

            return Arrays.asList(bidList);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(buffIn != null) {
                try {
                    buffIn.close();
                } catch(Exception e) { }
            }
            if(in != null) {
                try {
                    in.close();
                } catch(Exception e) { }
            }
        }

        return new ArrayList<CoinTrade>();
    }

    public CoinDept extractDeptData() {

        URL obj = null;
        InputStream in = null;
        BufferedInputStream buffIn = null;

        try {
            obj = new URL(BTC_DEPT_URL);
            HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
            in = conn.getInputStream();
            buffIn = new BufferedInputStream(in);

            byte[] data      = new byte[512];
            int bytesRead = -1;

            ByteArrayOutputStream memOut = new ByteArrayOutputStream();
            while((bytesRead = buffIn.read(data)) != -1) {
                memOut.write(data, 0, bytesRead);
            }

            memOut.close();

            return JsonIterator.deserialize(memOut.toByteArray(), CoinDept.class);

            // Debug
            // Arrays.stream(tradeList).forEach(c -> System.out.println(">>> " + c.displayData()));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(buffIn != null) {
                try {
                    buffIn.close();
                } catch(Exception e) { }
            }
            if(in != null) {
                try {
                    in.close();
                } catch(Exception e) { }
            }
        }

        return null;
    }

    public TradeTicker extractTickerData() {

        URL obj = null;
        InputStream in = null;
        BufferedInputStream buffIn = null;

        try {
            obj = new URL(BTC_TICKER_URL);
            HttpsURLConnection conn = (HttpsURLConnection) obj.openConnection();
            in = conn.getInputStream();
            buffIn = new BufferedInputStream(in);

            byte[] data      = new byte[512];
            int bytesRead = -1;

            ByteArrayOutputStream memOut = new ByteArrayOutputStream();
            while((bytesRead = buffIn.read(data)) != -1) {
                memOut.write(data, 0, bytesRead);
            }

            memOut.close();

            return JsonIterator.deserialize(memOut.toByteArray(), TradeTicker.class);

            // Debug
            // Arrays.stream(tradeList).forEach(c -> System.out.println(">>> " + c.displayData()));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(buffIn != null) {
                try {
                    buffIn.close();
                } catch(Exception e) { }
            }
            if(in != null) {
                try {
                    in.close();
                } catch(Exception e) { }
            }
        }

        return null;
    }

    public void publishData() {

    }
}
