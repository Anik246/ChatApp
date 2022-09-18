module com.example.assignmentnetworking {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignmentnetworking to javafx.fxml;
    exports com.example.assignmentnetworking;
}