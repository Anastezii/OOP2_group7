package bg.tu_varna.sit.carrent.presentation.controlers;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AdminWindowController  {

@FXML
    public Button buttonCreatePhirma;
@FXML
    public Button buttonCreateOper;
@FXML
    public Button buttonAddCar;


    @FXML
    public void initialize() {
        buttonCreatePhirma.setOnMouseClicked(this::handle);
        buttonCreateOper.setOnMouseClicked(this::handle1);
        buttonAddCar.setOnMouseClicked(this::handle2);
    }

    public void handle(Event event) {

        Parent root;
        try{
            URL pathClientLog = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/CreatePhirma.fxml");
            root= FXMLLoader.load(pathClientLog);
            Stage stage=new Stage();
            stage.setTitle("Create Compony Window");
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
            URL pathClientLog = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/AddOperator.fxml");
            root= FXMLLoader.load(pathClientLog);
            Stage stage=new Stage();
            stage.setTitle("Add Operator Window");
            stage.setScene(new Scene(root));
            stage.show();
            //((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }
    public void handle2(Event event) {
        Parent root;
        try{
            URL pathClientLog = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/AddCar.fxml");
            root= FXMLLoader.load(pathClientLog);
            Stage stage=new Stage();
            stage.setTitle("Add Car Window");
            stage.setScene(new Scene(root));
            stage.show();
            //((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }
}
