package com.example.squanlycuahangbanh;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;

public class QuanLyCuaHangBanh extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/quanlycuahangbanh/QuanLyCuaHang.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Quan Ly Tiem Banh");
        stage.setMinHeight(410);
        stage.setMinWidth(610);
        stage.setScene(scene);
        stage.show();
    }
    
}