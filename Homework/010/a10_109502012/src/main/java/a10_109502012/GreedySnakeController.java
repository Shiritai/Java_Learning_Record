package a10_109502012;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class GreedySnakeController implements EventHandler<KeyEvent>, Initializable{
    int headRowIndex = 0;
    int headColIndex = 0;
    int backRowIndex = 0;
    int backColIndex = 0;

    private int winRowIndex;
    private int winColIndex;
    private int maxRowIndex;
    private int maxColIndex;

    @FXML private GridPane mazeGridPane;
    @FXML private Pane nadekoBack;
    @FXML private Pane nadekoHead;
    @FXML private Pane winPane;
    @FXML private Text messageText;
    @FXML private Button goBackButton;
    
    @Override
    public void handle(KeyEvent e) {
        System.out.println("Got key");
        if (e.getCode().equals(KeyCode.UP)){
            backRowIndex = headRowIndex;    
            --headRowIndex;
        }
        else if (e.getCode().equals(KeyCode.DOWN)){
            backRowIndex = headRowIndex;    
            ++headRowIndex;
        }
        else if (e.getCode().equals(KeyCode.RIGHT)){
            backColIndex = headColIndex;    
            ++headColIndex;
        }
        else if (e.getCode().equals(KeyCode.LEFT)){
            backColIndex = headColIndex;    
            --headColIndex;
        }
        
        /* Check if lose */
        if (headRowIndex < 0 || headRowIndex >= maxRowIndex || headColIndex < 0 || headColIndex >= maxColIndex){
            // messageText.setText("你輸了!!!");
            goBackButton.requestFocus();
        }
        /* Check if win */
        if (headRowIndex == winRowIndex && headColIndex == winColIndex){
            // messageText.setText("移動到出口了!!!");
            goBackButton.requestFocus();
        }
        
        refresh();
    }

    private void refresh() {
        GridPane.setRowIndex(nadekoHead, headRowIndex);
        GridPane.setColumnIndex(nadekoHead, headColIndex);
        GridPane.setRowIndex(nadekoBack, backRowIndex);
        GridPane.setColumnIndex(nadekoBack, backColIndex);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        winRowIndex = GridPane.getRowIndex(winPane);
        winColIndex = GridPane.getColumnIndex(winPane);
        maxRowIndex = mazeGridPane.getRowCount();
        maxColIndex = mazeGridPane.getColumnCount();
        System.out.println("Ready to play");
        goBackButton.setOnMouseClicked(e -> MainApp.mainStage.setScene(MainApp.menuScene));
    }
    
}
