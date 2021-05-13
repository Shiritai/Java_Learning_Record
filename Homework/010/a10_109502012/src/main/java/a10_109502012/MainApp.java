package a10_109502012;

import java.io.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
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
        menuScene = new Scene(FXMLLoader.load(getClass().getResource("Menu.fxml")));
        mainStage.setTitle("Greedy Snake");
        mainStage.setScene(menuScene);
        mainStage.show();

        mainStage.setOnCloseRequest(e -> {
            mainStage.close();
            Platform.exit();
            System.exit(0);
        });
    }
}
