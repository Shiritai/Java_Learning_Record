package a11_109502012;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class MainController implements Initializable, EventHandler<KeyEvent>{
    
    @FXML private Pane mainPane;
    @FXML private Label plane;
    @FXML private Label bullet;

    LinkedList<Label> bullets = new LinkedList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        var fps = new Timeline(new KeyFrame(Duration.millis(100/6), e -> {
            var tmp = new ArrayList<Label>(bullets);
            tmp.forEach(b -> {
                b.setLayoutX(b.getLayoutX() + 5);
                if (b.getLayoutX() > mainPane.getWidth()){
                    bullets.remove(b);
                    mainPane.getChildren().remove(b);
                }
            });
        }));
        fps.setCycleCount(Timeline.INDEFINITE);
        fps.play();
    }

    @FXML
    public void handle(KeyEvent event) {
        if (event.getCode().equals(KeyCode.E)){
            var barrel_roll = new Timeline(
                new KeyFrame(Duration.millis(1.), d -> {
                    plane.setRotate(plane.getRotate() + 1);
                })
            );
            barrel_roll.setCycleCount(360);
            barrel_roll.play();
        }
        else if (event.getCode().equals(KeyCode.W)){
            plane.setLayoutY(plane.getLayoutY() - 5);
        }
        else if (event.getCode().equals(KeyCode.A)){
            plane.setLayoutX(plane.getLayoutX() - 5);
        }
        else if (event.getCode().equals(KeyCode.S)){
            plane.setLayoutY(plane.getLayoutY() + 5);
        }
        else if (event.getCode().equals(KeyCode.D)){
            plane.setLayoutX(plane.getLayoutX() + 5);
        }
        else if (event.getCode().equals(KeyCode.SPACE)){
            var newBullet = new Label(bullet.getText());
            newBullet.setLayoutX(plane.getLayoutX() + plane.getWidth());
            newBullet.setLayoutY(plane.getLayoutY() + plane.getHeight() / 2 - bullet.getHeight() / 2);
            bullets.push(newBullet);
            mainPane.getChildren().add(newBullet);
        }
    }
    
}
