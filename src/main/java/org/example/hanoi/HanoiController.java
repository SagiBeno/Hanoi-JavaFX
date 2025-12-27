package org.example.hanoi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HanoiController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
