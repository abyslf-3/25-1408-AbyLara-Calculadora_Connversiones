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

    private final ObservableList<String> history = FXCollections.observableArrayList();

    private final Map<String, Double> lengthUnits = Map.of(
            "Metros", 1.0,
            "Centímetros", 0.01,
            "Pulgadas", 0.0254,
            "Pies", 0.3048,
            "Yardas", 0.9144
    );

    private final Map<String, Double> weightUnits = Map.of(
            "Kilogramos", 1.0,
            "Gramos", 0.001,
            "Libras", 0.453592,
            "Onzas", 0.0283495
    );

    private final List<String> temperatureUnits = List.of("Celsius", "Fahrenheit", "Kelvin");

    @FXML
    public void initialize() {
        List<String> allUnits = new ArrayList<>();
        allUnits.addAll(lengthUnits.keySet());
        allUnits.addAll(weightUnits.keySet());
        allUnits.addAll(temperatureUnits);

        fromUnit.setItems(FXCollections.observableArrayList(allUnits));
        toUnit.setItems(FXCollections.observableArrayList(allUnits));
        historyList.setItems(history);

        convertButton.setOnAction(e -> convert());
        clearButton.setOnAction(e -> clearFields());
    }

    private void convert() {
        String inputText = inputField.getText();
        String from = fromUnit.getValue();
        String to = toUnit.getValue();

        if (inputText.isEmpty()) {
            showError("Ingrese un valor numérico.");
            return;
        }

        double value;
        try {
            value = Double.parseDouble(inputText);
        } catch (NumberFormatException e) {
            showError("Formato inválido. Solo se permiten números.");
            return;
        }

        if (from == null || to == null) {
            showError("Seleccione ambas unidades.");
            return;
        }

        if (from.equals(to)) {
            showError("Las unidades deben ser diferentes.");
            return;
        }

        double result;
        try {
            result = performConversion(value, from, to);
        } catch (IllegalArgumentException e) {
            showError(e.getMessage());
            return;
        }

        String output = String.format("%.4f %s = %.4f %s", value, from, result, to);
        resultLabel.setText("Resultado: " + output);
        updateHistory(output);
    }

    private double performConversion(double value, String from, String to) {
        if (lengthUnits.containsKey(from) && lengthUnits.containsKey(to)) {
            return value * lengthUnits.get(from) / lengthUnits.get(to);
        } else if (weightUnits.containsKey(from) && weightUnits.containsKey(to)) {
            return value * weightUnits.get(from) / weightUnits.get(to);
        } else if (temperatureUnits.contains(from) && temperatureUnits.contains(to)) {
            return convertTemperature(value, from, to);
        } else {
            throw new IllegalArgumentException("Las unidades no son compatibles.");
        }
    }

    private double convertTemperature(double value, String from, String to) {
        double celsius;
        switch (from) {
            case "Celsius": celsius = value; break;
            case "Fahrenheit": celsius = (value - 32) * 5 / 9; break;
            case "Kelvin": celsius = value - 273.15; break;
            default: throw new IllegalArgumentException("Unidad de temperatura inválida.");
        }

        switch (to) {
            case "Celsius": return celsius;
            case "Fahrenheit": return celsius * 9 / 5 + 32;
            case "Kelvin": return celsius + 273.15;
            default: throw new IllegalArgumentException("Unidad de temperatura inválida.");
        }
    }

    private void updateHistory(String entry) {
        if (history.size() == 10) {
            history.remove(0);
        }
        history.add(entry);
    }

    private void clearFields() {
        inputField.clear();
        fromUnit.setValue(null);
        toUnit.setValue(null);
        resultLabel.setText("Resultado:");
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error de conversión");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
