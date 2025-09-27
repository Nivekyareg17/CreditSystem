package com.sena.introductionMaven;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CrediSystem/crud.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 200);
        scene.getStylesheets().add(getClass().getResource("CrediSystem/crudStyle.css").toExternalForm());

        stage.setTitle("Controles de Selección");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}