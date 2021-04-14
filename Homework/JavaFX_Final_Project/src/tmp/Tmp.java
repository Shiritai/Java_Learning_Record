package tmp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class Tmp extends Application {
    @Override
    public void start(Stage mainStage){
        var fxmlURL = this.getClass().getResource("views/tmp.fxml");
        var loader = new FXMLLoader(fxmlURL);
        Parent root = loader.load();
        mainStage.setTitle("Hello Monogatari");
        mainStage.setScene(new Scene(root));
        mainStage.show();
    }
    public static void main(String [] args){
        launch(args);
    }
}
