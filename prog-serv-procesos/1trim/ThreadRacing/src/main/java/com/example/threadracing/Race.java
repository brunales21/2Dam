package com.example.threadracing;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Race extends Application {
    private final int circleRadius = 20;
    private final int circleMoveDistance = 10;
    @FXML
    Circle circle1;
    @FXML
    Circle circle2;
    @FXML
    Circle circle3;

    @FXML
    public void onAction(MouseEvent mouseEvent) {
        new Thread(() -> mover(circle1)).start();
        new Thread(() -> mover(circle2)).start();
        new Thread(() -> mover(circle3)).start();

    }

    private void mover(Circle circle) {
        while (true) {
            double currentX = circle.getCenterX();
            if (currentX + circleMoveDistance + circleRadius <= 400) {
                circle.setCenterX(currentX + circleMoveDistance);
            } else {
                circle.setCenterX(circleRadius);  // Reiniciar el círculo
            }

            try {
                Thread.sleep(100);  // Controla la velocidad del movimiento
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
