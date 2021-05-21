package p10_109502012;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class MazeController implements Initializable{
    
    @FXML private GridPane mazeGridPane;
    @FXML private Pane walk;
    @FXML private Pane winPane;
    @FXML private Text messageText;
    @FXML private Button goBackButton;
    
    int walkRowIndex = 0;
    int walkColIndex = 0;
    private boolean isChange = false;
    private BooleanProperty youWin = new SimpleBooleanProperty(false);
    private BooleanProperty youLose = new SimpleBooleanProperty(false);

    private int winRowIndex;
    private int winColIndex;
    private int maxRowIndex;
    private int maxColIndex;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        winRowIndex = GridPane.getRowIndex(winPane);
        winColIndex = GridPane.getColumnIndex(winPane);
        maxRowIndex = mazeGridPane.getRowCount();
        maxColIndex = mazeGridPane.getColumnCount();
        
        goBackButton.setOnMouseClicked(e -> MainApp.mainStage.setScene(MainApp.menuScene));
        youWin.addListener((a, b, c) -> {
            if (c){
                messageText.setText("移動到出口了!!!");
                goBackButton.requestFocus();
            }
            else {
                messageText.setText("");
            }
        });
        youLose.addListener((a, b, c) -> {
            if (c){
                messageText.setText("你輸了!!!");
                goBackButton.requestFocus();
            }
            else {
                messageText.setText("");
            }
        });

        MainApp.mainStage.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode().equals(KeyCode.SPACE)){
                walkRowIndex = 0;
                walkColIndex = 0;
                isChange = true;
                youWin.set(false);
                youLose.set(false);
            }
            if (!youWin.getValue() && !youLose.getValue()){
                if (e.getCode().equals(KeyCode.UP)){
                    --walkRowIndex;
                    isChange = true;
                }
                else if (e.getCode().equals(KeyCode.DOWN)){
                    ++walkRowIndex;
                    isChange = true;
                }
                else if (e.getCode().equals(KeyCode.RIGHT)){
                    ++walkColIndex;
                    isChange = true;
                }
                else if (e.getCode().equals(KeyCode.LEFT)){
                    --walkColIndex;
                    isChange = true;
                }
            }
            if (isChange){
                /* Check if lose */
                if (walkRowIndex < 0 || walkRowIndex >= maxRowIndex || walkColIndex < 0 || walkColIndex >= maxColIndex){
                    youLose.set(true);
                }
                else {
                    /* Check if win */
                    if (walkRowIndex == winRowIndex && walkColIndex == winColIndex){
                        youWin.setValue(true);
                    }
                    refresh();
                }
                isChange = false;
            }
            e.consume();
        });
    }

    private void refresh() {
        GridPane.setRowIndex(walk, walkRowIndex);
        GridPane.setColumnIndex(walk, walkColIndex);
    }
}
