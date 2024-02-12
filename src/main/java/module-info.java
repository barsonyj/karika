module com.example.karika {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.karika to javafx.fxml;
    exports com.example.karika;
}