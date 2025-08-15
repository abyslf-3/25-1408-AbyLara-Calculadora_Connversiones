package com.helloword.calc_conversiones;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/helloword/calc_conversiones/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Calculadora de Conversiones");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
