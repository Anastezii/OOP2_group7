package bg.tu_varna.sit.carrent.presentation.controlers;


import bg.tu_varna.sit.carrent.application.HelloApplication;
import bg.tu_varna.sit.carrent.business.services.AdminService;
import bg.tu_varna.sit.carrent.business.services.ClientService;
import bg.tu_varna.sit.carrent.business.services.OperatorService;
import bg.tu_varna.sit.carrent.common.Constants;
import bg.tu_varna.sit.carrent.presentation.models.AdminListViewMOdel;
import bg.tu_varna.sit.carrent.presentation.models.ClientListViewMOdel;
import bg.tu_varna.sit.carrent.presentation.models.HelloModel;
import bg.tu_varna.sit.carrent.presentation.models.OperatorListViewModel;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {

    @FXML
    public Button ExitButton;
    @FXML
    private Button OperatorButton;

    @FXML
    private Button AdminButton;

    @FXML
    private Button ClientButton;




    @FXML
    public void initialize(){

        OperatorButton.setOnMouseClicked(this::extracted2);
        AdminButton.setOnMouseClicked(this::extracted1);
        ClientButton.setOnMouseClicked(this::extracted);
        ExitButton.setOnMouseClicked(this::exitWindow);
    }



    private void extracted(MouseEvent mouseEvent) {
        Parent root;
        try{
            URL pathClientLog = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/ClientLogin.fxml");
            root= FXMLLoader.load(pathClientLog);
            Stage stage=new Stage();
            stage.setTitle("Client Log");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }

    private void extracted1(MouseEvent mouseEvent) {
        Parent root;
        try{
            URL pathAdminLog = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/AdminLogin.fxml");
            root= FXMLLoader.load(pathAdminLog);
            Stage stage=new Stage();
            stage.setTitle("Admin Log");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }
    private void extracted2(MouseEvent mouseEvent) {
        Parent root;
        try{
            URL pathOperatorLog = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/OperatorLogin.fxml");
            root= FXMLLoader.load(pathOperatorLog);
            Stage stage=new Stage();
            stage.setTitle("Operator Log");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }
    @FXML
    private void exitWindow(Event event) {

            Stage stage=(Stage) ExitButton.getScene().getWindow();
           stage.close();

    }

    }







