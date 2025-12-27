module org.example.hanoi {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.hanoi to javafx.fxml;
    exports org.example.hanoi;
}