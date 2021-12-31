package bg.tu_varna.sit.carrent.presentation.controlers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ClientWindowController {
    @FXML
    public Button buttonCars;
    @FXML
    public Button buttonRent;


    @FXML
    public void initialize() {
        buttonCars.setOnMouseClicked(this::handle);
        buttonRent.setOnMouseClicked(this::handle1);
    }

    public void handle(Event event) {
        Parent root;
        try{
            URL pathClientLog = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/CarsView.fxml");
            root= FXMLLoader.load(pathClientLog);
            Stage stage=new Stage();
            stage.setTitle("Car`s View Window");
            stage.setScene(new Scene(root));
            stage.show();
            //((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }
    public void handle1(Event event) {
        Parent root;
        try{
            URL pathClientLog = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/Checkrent.fxml");
            root= FXMLLoader.load(pathClientLog);
            Stage stage=new Stage();
            stage.setTitle("check Rent Window");
            stage.setScene(new Scene(root));
            stage.show();
            //((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }


}
