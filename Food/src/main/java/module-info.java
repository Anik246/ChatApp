module com.example.food {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.food to javafx.fxml;
    exports com.example.food;
}