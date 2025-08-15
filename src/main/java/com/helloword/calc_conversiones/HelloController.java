package com.helloword.calc_conversiones;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class HelloController {

    @FXML private TextField inputField;
    @FXML private ComboBox<String> fromUnit;
    @FXML private ComboBox<String> toUnit;
    @FXML private Button convertButton;
    @FXML private Button clearButton;
    @FXML private Label resultLabel;
    @FXML private ListView<String> historyList;
    @FXML

    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}