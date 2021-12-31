package bg.tu_varna.sit.carrent.presentation.controlers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class CarsViewController {
    @FXML
    public ComboBox Color;
    @FXML
    public ComboBox SmokerType;
    @FXML
    public ComboBox CarModel;
    @FXML
    public ComboBox Year;
    @FXML
    public ComboBox ClassCar;
    @FXML
    public Button BackButton;

    @FXML
    public void initialize() {
        BackButton.setOnMouseClicked(this::handle);
    }
    public void handle(Event event) {
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
