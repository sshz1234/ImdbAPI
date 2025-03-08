module com.example.assign2api {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;


    opens com.example.assign2api to javafx.fxml;
    exports com.example.assign2api;
}