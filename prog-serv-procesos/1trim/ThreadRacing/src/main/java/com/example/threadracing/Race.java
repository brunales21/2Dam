package com.example.threadracing;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class Race extends Application {
    private final int circleRadius = 20;
    private int circleMoveDistance = 10;
    private int speed;
    private int initPos = 10;
    @FXML
    Circle circle1;
    @FXML
    Circle circle2;
    @FXML
    Circle circle3;
    Thread t1;
    Thread t2;
    Thread t3;


    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    public void onAction(MouseEvent mouseEvent) {
        t1 = new Thread(() -> {
            while (!t1.isInterrupted()) {
                mover(circle1);

            }
        });
        t2 = new Thread(() -> {
            while (!t2.isInterrupted()) {
                mover(circle2);
            }
        });
        t3 = new Thread(() -> {
            while (!t3.isInterrupted()) {
                mover(circle3);

            }
        });

        String idButton = ((Button) mouseEvent.getSource()).getId();
        if (idButton.equals("empezar")) {
            empezar();

        } else if (idButton.equals("detener")) {
            interruptThreads(t1, t2, t3);
            System.out.println(t1.isInterrupted());
            System.out.println(t1.getState());

        }

    }

    private void empezar() {
        circleMoveDistance = 10;
        circle1.setTranslateX(initPos);
        circle2.setTranslateX(initPos);
        circle3.setTranslateX(initPos);
        t1.start();
        t2.start();
        t3.start();
    }

    private void interruptThreads(Thread... threads) {
        for (Thread thread : threads) {
            thread.interrupt();
        }
        circleMoveDistance = 0;
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
                //circle.setTranslateX(initPos);
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
