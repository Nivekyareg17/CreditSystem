package com.sena.introductionMaven;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to the jungles");
    }

    @FXML
    protected void navegateWithNode() throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("second-view.fxml"));
        Parent newroot = loader.load();

        //get corrent scene
        Scene scene = welcomeText.getScene();
        scene.setRoot(newroot);
    }

    @FXML
    protected void navegateWithScene() throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("second-view.fxml"));
        Scene scene = new Scene(loader.load(), 320, 240);

        //set corrent stage
        Stage stage = (Stage)welcomeText.getScene().getWindow();
        stage.setScene(scene);

    }
}

