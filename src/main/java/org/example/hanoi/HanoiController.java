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

    public Integer selectedFromPeg = null;

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

        peg1.setOnMouseClicked(e -> onPegClicked(0));
        peg2.setOnMouseClicked(e -> onPegClicked(1));
        peg3.setOnMouseClicked(e -> onPegClicked(2));
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

    private void onPegClicked(int pegIndex) {
        if (selectedFromPeg == null) {
            if (model.getPegs()[pegIndex].isEmpty()) return;
            selectedFromPeg = pegIndex;
            highlightPeg(pegIndex, true);
            System.out.println("From = " + selectedFromPeg);
        } else {
            int from = selectedFromPeg;
            int to = pegIndex;
            selectedFromPeg = null;
            highlightPeg(from, false);
            boolean ok = model.move(from, to);
            if (ok) {
                drawDisks();
            } else {
                System.out.println("Szabálytalan lépés!");
            }
            System.out.println("Move: " + from + " -> " + to);
        }
    }

    private void highlightPeg(int pegIndex, boolean on) {
        Rectangle pegRect = switch (pegIndex) {
            case 0 -> peg1;
            case 1 -> peg2;
            case 2 -> peg3;
            default -> null;
        };
        if (pegRect == null) return;

        if (on) {
            pegRect.setStroke(Paint.valueOf("#ffd54a"));
            pegRect.setStrokeWidth(4);
        } else {
            pegRect.setStroke(null);
            pegRect.setStrokeWidth(0);
        }
    }
}
