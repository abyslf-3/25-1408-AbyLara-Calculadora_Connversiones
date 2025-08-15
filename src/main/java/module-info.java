module com.helloword.calc_conversiones {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.helloword.calc_conversiones to javafx.fxml;
    exports com.helloword.calc_conversiones;
}