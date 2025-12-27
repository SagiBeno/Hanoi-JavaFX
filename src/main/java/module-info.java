module org.example.hanoi {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens org.example.hanoi to javafx.fxml;
    exports org.example.hanoi;
}