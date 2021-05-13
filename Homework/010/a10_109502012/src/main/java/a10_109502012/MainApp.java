package a10_109502012;

import java.awt.SystemTray;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import javafx.stage.*;

public class MainApp extends Application{
    
    public static Stage mainStage;
    public static Scene menuScene;

    public static void main(String [] args){
        launch(args);
    }

    @Override
    public void start (Stage mainStage) throws IOException{
        MainApp.mainStage = mainStage;
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        menuScene= new Scene(root);
        // mainStage.setTitle("Greedy Snake");
        mainStage.setTitle("Walk to Exit");
        mainStage.setScene(menuScene);
        mainStage.show();

        mainStage.setOnCloseRequest(e -> {
            mainStage.close();
            Platform.exit();
            System.exit(0);
        });
    }
}
