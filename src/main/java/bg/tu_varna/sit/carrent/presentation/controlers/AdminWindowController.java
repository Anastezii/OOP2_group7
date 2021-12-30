package bg.tu_varna.sit.carrent.presentation.controlers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class AdminWindowController  {

@FXML
private Button buttonAdminWindow;


    @FXML
    public void initialize() {
        buttonAdminWindow.setOnMouseClicked(this::handle);
    }

    public void handle(MouseEvent event) {
System.out.println("hello");
    }
}
