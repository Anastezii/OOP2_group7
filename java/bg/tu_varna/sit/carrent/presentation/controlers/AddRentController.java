package bg.tu_varna.sit.carrent.presentation.controlers;

import bg.tu_varna.sit.carrent.business.services.PhirmaService;
import bg.tu_varna.sit.carrent.business.services.RentService;
import bg.tu_varna.sit.carrent.data.entities.Rent;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
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

public class AddRentController {


    @FXML
    public ComboBox Car;

    @FXML
    public ComboBox Client;
    @FXML
    public ComboBox Compony;
    @FXML
    public Button RentButton;
    @FXML
    public Button BackButton;
    @FXML
    public Button TableButton;

    @FXML
    public DatePicker StartDate;
    @FXML
    public DatePicker EndDate;


    private final RentService service = RentService.getInstance();

    @FXML
    public void initialize() {
       loadCars();
        RentButton.setOnMouseClicked(this::handle);
        BackButton.setOnMouseClicked(this::handle1);
        TableButton.setOnMouseClicked(this::handle2);
    }

    private void loadCars() {
        System.out.println("Hello");

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
            URL pathOpWind = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/TableViewRent.fxml");
            root= FXMLLoader.load(pathOpWind);
            Stage stage=new Stage();
            stage.setTitle("Rent Table");
            stage.setScene(new Scene(root));
            stage.show();
            //((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }
}
