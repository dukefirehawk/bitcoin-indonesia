package com.dukefirehawk;

import com.dukefirehawk.controller.ExchangeController;
import com.dukefirehawk.model.Coin;
import com.dukefirehawk.model.Bid;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    public int maxBid = 5;

    /**
     * The data as an observable list of Coins.
     */
    private ObservableList<Coin> exchangeData = FXCollections.observableArrayList();

    private ObservableList<Bid> buyBidData = FXCollections.observableArrayList();

    private ObservableList<Bid> sellBidData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("view/ExchangeView.fxml"));
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Indonesia Bitcoin Exchange");

        //exchangeData.add(new Coin(2, 1.0, 5, 1.1, 1000, 1.15, new Date()));
        //exchangeData.add(new Coin(5, 1.0, 10, 1.1, 1000, 1.15, new Date()));

        //buyBidData.add(new Bid(0.039, 1000));

        //sellBidData.add(new Bid(0.040, 3000));

        initRootLayout();
        showExhangeView();

    }

    private void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/RootLayout.fxml"));
            rootLayout = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout); //, 600, 400);
            this.primaryStage.setScene(scene);
            this.primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showExhangeView() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/ExchangeView.fxml"));
            BorderPane exchangeView = loader.load();

            // Set exchange overview into the center of root layout.
            rootLayout.setCenter(exchangeView);

            // Give the controller access to the main app.
            ExchangeController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Returns the data as an observable list of Coins.
     * @return
     */
    public ObservableList<Coin> getExchangeData() {
        return exchangeData;
    }

    public ObservableList<Bid> getBuyBidData() {
        return buyBidData;
    }

    public ObservableList<Bid> getSellBidData() {
        return sellBidData;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
