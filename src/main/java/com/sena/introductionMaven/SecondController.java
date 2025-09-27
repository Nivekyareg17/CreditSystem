package com.sena.introductionMaven;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.IOException;

public class SecondController {

    @FXML
    private Label secondText;


    @FXML
    protected void navegateHelloView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Hello-view.fxml"));
        Parent newRoot = loader.load();

        Scene scene = secondText.getScene();
        scene.setRoot(newRoot);
    }

}
