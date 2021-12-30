package bg.tu_varna.sit.carrent.presentation.controlers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ClientWindowController {

    @FXML
    private Button buttonClientWindow;

    @FXML
    public void initialize() {
        buttonClientWindow.setOnMouseClicked(this::handle);
    }

    public void handle(MouseEvent event) {
        System.out.println("hello");
    }


}
