package com.dukefirehawk.controller;

import com.dukefirehawk.MainApp;
import com.dukefirehawk.model.Bid;
import com.dukefirehawk.model.Coin;
import com.dukefirehawk.services.DataService;
import com.dukefirehawk.services.data.CoinBid;
import com.dukefirehawk.services.data.CoinDept;
import com.dukefirehawk.services.data.CoinTrade;
import com.dukefirehawk.services.data.TradeTicker;
import com.jsoniter.any.Any;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.fxml.FXML;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExchangeController {

    private static final int MAX_BID = 5;

    @FXML
    private TableView<Coin> exchangeTable;

    @FXML
    private TableColumn<Coin, String> dateColumn;

    @FXML
    private TableColumn<Coin, String> priceColumn;

    @FXML
    private TableColumn<Coin, String> amountColumn;

    @FXML
    private TableColumn<Coin, String> tidColumn;

    @FXML
    private TableColumn<Coin, String> tradeTypeColumn;

    @FXML
    private TableView<Bid> buyBidTable;

    @FXML
    private TableColumn<Bid, String> buyBidPriceColumn;

    @FXML
    private TableColumn<Bid, String> buyBidVolumeColumn;

    @FXML
    private TableView<Bid> sellBidTable;

    @FXML
    private TableColumn<Bid, String> sellBidPriceColumn;

    @FXML
    private TableColumn<Bid, String> sellBidVolumeColumn;


    @FXML
    Button startButton;

    @FXML
    Button stopButton;

    private MainApp mainApp;

    private static int count = 1;

    private DataService service = new DataService();

    private ScheduledExecutorService executor = null;

    @FXML
    public void startDataFeed(ActionEvent event) {

        System.out.println("Clicked start button");

        if(executor == null) {
            System.out.println("Create a new executor");
            startScheduledTask();
        } else {
            if(executor.isShutdown()) {
                // Rerun the task
                System.out.println("Restart an executor");
                startScheduledTask();
            }
        }

        //updateExchange();
    }

    private void startScheduledTask() {
        // Run the tesk
        Runnable task = () -> updateExchange();
        int initialDelay = 0;
        int period = 3;

        executor = Executors.newScheduledThreadPool(1);
        executor.scheduleWithFixedDelay(task, initialDelay, period, TimeUnit.SECONDS);
    }

    private final void updateExchange() {
        System.out.println("Scheduling: " + System.nanoTime());

        showTrades(service.extractTradeData());

        CoinDept dept = service.extractDeptData();
        showBuyBid(dept.buy);
        showSellBid(dept.sell);

        TradeTicker ticker = service.extractTickerData();
        System.out.println(">>> " + ticker.ticker.displayData());

    }

    private void showTrades(List<CoinTrade> tradeList) {

        tradeList.sort(Comparator.comparing(CoinTrade::getDate).reversed());

        mainApp.getExchangeData().clear();
        int count = 0;
        for(CoinTrade t: tradeList) {
            mainApp.getExchangeData().add(new Coin(t.date, t.price, t.amount, t.tid, t.type));
            count++;
            if(count >= MAX_BID) {
                break;
            }
        }
        //tradeList.forEach(c -> System.out.println(">>> " + c.displayData()));

    }

    private void showBuyBid(Any bids[]) {
        List<CoinBid> buyBidList = parseCoinBid(bids);
        buyBidList.sort(Comparator.comparing(CoinBid::getPrice).reversed());
        mainApp.getBuyBidData().clear();
        int count = 0;
        for(CoinBid b: buyBidList) {
            mainApp.getBuyBidData().add(new Bid(b.amount, b.price));
            count++;
            if(count >= MAX_BID) {
                break;
            }
        }
        //buyBidList.forEach(c -> System.out.println(">>> " + c.displayData()));
    }

    private void showSellBid(Any bids[]) {
        List<CoinBid> sellBidList = parseCoinBid(bids);
        sellBidList.sort(Comparator.comparing(CoinBid::getPrice));

        int count = 0;
        mainApp.getSellBidData().clear();
        for(CoinBid b: sellBidList) {
            mainApp.getSellBidData().add(new Bid(b.amount, b.price));
            count++;
            if(count >= MAX_BID) {
                break;
            }
        }
        //sellBidList.forEach(c -> System.out.println(">>> " + c.displayData()));

    }

    private List<CoinBid> parseCoinBid(Any data[]) {
        List<CoinBid> bidList = new ArrayList<CoinBid>();
        for(Any c: data ) {
            CoinBid bid = new CoinBid();
            bid.price = c.get(0).toString();
            bid.amount = c.get(1).toString();
            bidList.add(bid);
        }
        return bidList;
    }

    @FXML
    public void stopDataFeed(ActionEvent event) {

        System.out.println("Clicked stop button");

        if(executor != null) {
            executor.shutdown();
            if (executor.isShutdown()) {
                System.out.println("Executor has shutdown");
            }
        }
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    public void initialize() {
        // Initialize the exchange table with the columns.
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
        amountColumn.setCellValueFactory(cellData -> cellData.getValue().amountProperty());
        tidColumn.setCellValueFactory(cellData -> cellData.getValue().tidProperty());
        tradeTypeColumn.setCellValueFactory(cellData -> cellData.getValue().tradeTypeProperty());

        // Buy Bid Table
        buyBidVolumeColumn.setCellValueFactory(cellData -> cellData.getValue().volumeProperty());
        buyBidPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty());

        // Sell Bid Table
        sellBidVolumeColumn.setCellValueFactory(cellData -> cellData.getValue().volumeProperty());
        sellBidPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty());

    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        exchangeTable.setItems(mainApp.getExchangeData());

        buyBidTable.setItems(mainApp.getBuyBidData());

        sellBidTable.setItems(mainApp.getSellBidData());

    }

}
