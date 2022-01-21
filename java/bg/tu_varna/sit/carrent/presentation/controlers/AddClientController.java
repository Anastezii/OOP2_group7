package bg.tu_varna.sit.carrent.presentation.controlers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AddClientController {
    @FXML
    public TextField ClientLogin;
    @FXML
    public TextField ClientPass;
    @FXML
    public Button AddClient;
    @FXML
    public Button BackButton;
    @FXML
    public Button TableButton;

    @FXML
    public void initialize() {
        AddClient.setOnMouseClicked(this::handle);
        BackButton.setOnMouseClicked(this::handle1);
        TableButton.setOnMouseClicked(this::handle2);
    }
    public void handle(Event event) {
        System.out.println("Hello");
    }
    public void handle1(Event event) {
        Parent root;
        try{
            URL pathOperatorLog = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/OperatorWindow.fxml");
            root= FXMLLoader.load(pathOperatorLog);
            Stage stage=new Stage();
            stage.setTitle("Operator Window");
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
            URL pathTable = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/TableViewClient.fxml");
            root= FXMLLoader.load(pathTable);
            Stage stage=new Stage();
            stage.setTitle("Clent Table");
            stage.setScene(new Scene(root));
            stage.show();
            //((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }

}
