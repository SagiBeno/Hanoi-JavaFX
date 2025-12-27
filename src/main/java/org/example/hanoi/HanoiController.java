package org.example.hanoi;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HanoiController implements Initializable{
    @FXML public Pane board;
    @FXML public Rectangle peg1;
    @FXML public Rectangle peg2;
    @FXML public Rectangle peg3;

    public HanoiModel model;
    public List<Node> pegs;
    public ComboBox<Integer> diskNumber;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new HanoiModel(3);
        pegs = new ArrayList<>(board.getChildren());

        diskNumber.getItems().setAll(3,4,5,6,7);
        diskNumber.setValue(3);

        diskNumber.setOnAction(e -> {
            int n = diskNumber.getValue();
            model.reset(n);
            drawDisks();
        });
        drawDisks();
    }

    private Paint getDiskColor(int disk, int maxDisk) {
        return Color.hsb(
                (disk * 360.0) / maxDisk,
                0.8,
                0.9
        );
    }

    public void drawDisks() {
        board.getChildren().setAll(pegs);

        double[] pegX = {105, 300, 495};
        double baseY = 240;

        double maxWidth = 200;

        for (int peg = 0; peg < 3; peg++) {
            int level = 0;

            for (int disk : model.getPegs()[peg]) {
                Rectangle rectangle = new Rectangle();
                rectangle.setHeight(20);

                double step = maxWidth / model.getDiskNumber();
                double width = disk * step;

                rectangle.setWidth(width);
                rectangle.setFill(getDiskColor(disk, model.getDiskNumber()));

                rectangle.setLayoutX(pegX[peg] - width / 2);
                rectangle.setLayoutY(baseY - level * 20);

                rectangle.setArcWidth(10.0);
                rectangle.setArcHeight(10.0);

                int pegIndex = peg;
                rectangle.setOnMouseClicked(e -> System.out.println("Kattintott rúd: " + pegIndex));

                board.getChildren().add(rectangle);
                level++;
            }
        }
    }
}
