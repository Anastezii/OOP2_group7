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

public class AddCarController {
    @FXML
    public Button AddCarButton;
    @FXML
    public TextField Model;
    @FXML
    public TextField Color;
    @FXML
    public TextField Year;
    @FXML
    public TextField Class;
    @FXML
    public TextField Smoker;
    @FXML
    public TextField RegNum;
    @FXML
    public TextField Brand;
    @FXML
    public Button BackButton;


    @FXML
    public void initialize() {
       AddCarButton.setOnMouseClicked(this::handle);
        BackButton.setOnMouseClicked(this::handle1);

    }
    public void handle(Event event) {
        System.out.println("Hello");
    }
    public void handle1(Event event) {
        Parent root;
        try{
            URL pathAdminLog = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/AdminWindow.fxml");
            root= FXMLLoader.load(pathAdminLog);
            Stage stage=new Stage();
            stage.setTitle("Admin Window");
            stage.setScene(new Scene(root));
            stage.show();
            //((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }
}
