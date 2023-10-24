package com.example.threadracing;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class Race extends Application {
    private final int circleRadius = 20;
    private final int circleMoveDistance = 10;
    private int speed;

    @FXML
    Circle circle1;
    @FXML
    Circle circle2;
    @FXML
    Circle circle3;

    public static void main(String[] args) {
        launch(args);
    }
    @FXML
    public void onAction(MouseEvent mouseEvent) {
        Thread t1 = new Thread(() -> mover(circle1));
        Thread t2 = new Thread(() -> mover(circle2));
        Thread t3 = new Thread(() -> mover(circle3));

        t1.start();
        t2.start();
        t3.start();

    }

    private void mover(Circle circle) {
        while (true) {
            switch (circle.getId()) {
                case "circle1":
                    speed = 100;
                    break;
                case "circle2":
                    speed = 150;
                    break;
                case "circle3":
                    speed = 200;
                    break;
            }

            double currentX = circle.getTranslateX();
            if (currentX + circleMoveDistance + circleRadius <= 400) {
                final double newX = currentX + circleMoveDistance;
                Platform.runLater(() -> circle.setTranslateX(newX));
            } else {
                return;
            }

            try {
                Thread.sleep(speed);  // Controla la velocidad del movimiento
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    @Override
    public void start(Stage stage) {
        FXMLLoader fxmlLoader = new FXMLLoader(Race.class.getResource("hello-view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 500, 600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle("Race");
        stage.setScene(scene);
        stage.show();
    }
}
