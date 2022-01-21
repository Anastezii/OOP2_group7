package bg.tu_varna.sit.carrent.presentation.controlers;

import bg.tu_varna.sit.carrent.business.services.CarService;
import bg.tu_varna.sit.carrent.data.entities.Cars;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class CarsViewController {

    @FXML
    public Button BackButton;
    @FXML
    public TableView<Cars> TableCarsClient;
    @FXML
    public TableColumn<Cars, String> brand;
    @FXML
    public TableColumn<Cars, String> model;
    @FXML
    public TableColumn<Cars, String> carcl;
    @FXML
    public TableColumn<Cars, String> year;
    @FXML
    public TableColumn<Cars, String> colour;
    @FXML
    public TableColumn<Cars, String> smoker;


    private final CarService service = CarService.getInstance();

    @FXML
    public void initialize() {

        loadDate();
        BackButton.setOnMouseClicked(this::handle);
    }

    private void loadDate() {
        ObservableList<Cars> carsObservableList = service.getAllTask();



        model.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getIdMODEL().getModel_name()));
        colour.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getCars_color()));
        year.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getCars_year()));
        carcl.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getCars_class()));
        smoker.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getIdSMOKER().getSmoker_Type()));
        brand.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getIdMODEL().getBrand().getBrand_name()));

        TableCarsClient.setItems(carsObservableList);
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
