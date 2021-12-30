package bg.tu_varna.sit.carrent.presentation.controlers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class OperatorWindowController {
    @FXML
    private Button buttonOperatorWindow;

    @FXML
    public void initialize() {
        buttonOperatorWindow.setOnMouseClicked(this::handle);
    }

    public void handle(MouseEvent event) {
        System.out.println("hello");
    }


}
