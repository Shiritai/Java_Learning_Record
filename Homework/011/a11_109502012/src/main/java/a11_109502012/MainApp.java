package a11_109502012;

import java.io.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

public class MainApp extends Application{
    
    public static Stage mainStage;
    public static Scene scene;

    public static void main(String [] args){
        launch(args);
    }

    @Override
    public void start (Stage mainStage) throws IOException{
        MainApp.mainStage = mainStage;
        scene = new Scene(FXMLLoader.load(getClass().getResource("Game.fxml")));
        mainStage.setTitle("GAME");
        scene.getRoot().requestFocus();
        mainStage.setScene(scene);
        mainStage.setResizable(false);
        mainStage.show();

        mainStage.setOnCloseRequest(e -> {
            mainStage.close();
            Platform.exit();
            System.exit(0);
        });
    }
}
