package bg.tu_varna.sit.carrent.presentation.controlers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class CheckRentController {
    @FXML
    public TextField InputLogin;

    @FXML
    public ComboBox CarRent;
    @FXML
    public Button CheckRent;
    @FXML
    public Button BackButton;
    @FXML
    public DatePicker Start;
    @FXML
    public DatePicker End;

    @FXML
    public void initialize() {
        CheckRent.setOnMouseClicked(this::handle);
        BackButton.setOnMouseClicked(this::handle1);
    }
    public void handle(Event event) {
        System.out.println("Hello");
    }
    public void handle1(Event event) {
        Parent root;
        try{
            URL pathClientLog = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/ClientWindow.fxml");
            root= FXMLLoader.load(pathClientLog);
            Stage stage=new Stage();
            stage.setTitle("Client Window");
            stage.setScene(new Scene(root));
            stage.show();
            //((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }
}
