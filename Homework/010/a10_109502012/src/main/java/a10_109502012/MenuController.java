package a10_109502012;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class MenuController {
    
    @FXML
    void hitExit(ActionEvent event) throws IOException {
        var mazeScene = new Scene(FXMLLoader.load(getClass().getResource("Maze.fxml")));
        mazeScene.getRoot().requestFocus();
        MainApp.mainStage.setScene(mazeScene);
    }

    @FXML
    void hitStart(ActionEvent event) {
        MainApp.mainStage.close();
    }
}
