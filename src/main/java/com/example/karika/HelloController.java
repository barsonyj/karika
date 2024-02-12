package com.example.karika;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class HelloController {

    @FXML private Pane pnJatek;
    @FXML private Button btTimer;
    @FXML private Slider srSpeed;
    @FXML private Label lbSpeed;
    @FXML private Slider srRadius;
    @FXML private Label lbRadius;

    private AnimationTimer timer;
    private boolean run = false;

    private ImageView ball = new ImageView(new Image(getClass().getResourceAsStream("ball1.png")));
    private int alfa = 0;

    public void initialize() {
        pnJatek.setClip(new Rectangle(600, 600)); // Pane does not clip its content by default!
        ball.setLayoutX(500-32);
        ball.setLayoutY(300-32);
        pnJatek.getChildren().add(ball);
        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                mozgat();
            }
        };
    }

    @FXML private void onTimerClicked() {
        if (run == false) {
            timer.start(); btTimer.setText("Stop"); run = true;
        } else {
            timer.stop(); btTimer.setText("Start"); run = false;
        }
    }

    private void mozgat() {
        int r = (int)srRadius.getValue();
        lbRadius.setText("Radius: " + r);
        int x = (int)(300 + r * Math.cos(alfa/180.0*3.14))-32;
        int y = (int)(300 - r * Math.sin(alfa/180.0*3.14))-32;
        ball.setLayoutX(x);
        ball.setLayoutY(y);
        int speed = (int)srSpeed.getValue();
        lbSpeed.setText("Speed: " + speed);
        alfa += speed;
    }

    /*
    RotateTransition rt = new RotateTransition(Duration.millis(2000));
        rt.setFromAngle(0);
        rt.setToAngle(360);
    TranslateTransition tt = new TranslateTransition(Duration.millis(2000));
    tt.setFromY(TILE_HEIGHT * (y - rows));
    tt.setToY(y * TILE_HEIGHT);
    tt.play();
    ParallelTransition pt = new ParallelTransition(img, tt, rt);
    pt.play();
     */

}