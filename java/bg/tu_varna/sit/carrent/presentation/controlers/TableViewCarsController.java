package bg.tu_varna.sit.carrent.presentation.controlers;

import bg.tu_varna.sit.carrent.business.services.CarService;
import bg.tu_varna.sit.carrent.business.services.PhirmaService;
import bg.tu_varna.sit.carrent.data.entities.Cars;
import bg.tu_varna.sit.carrent.data.entities.Phirma;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class TableViewCarsController {

    @FXML
    public TableView<Cars> TableCars;
    @FXML
    public TableColumn<Cars,String> idCar;
    @FXML
    public TableColumn<Cars,String> model;
    @FXML
    public TableColumn<Cars,String> colour;
    @FXML
    public TableColumn<Cars,String> year;
    @FXML
    public TableColumn<Cars,String> classCar;
    @FXML
    public TableColumn<Cars,String> smoker;
    @FXML
    public TableColumn<Cars,String> regNum;

    @FXML
    public Button BackButton;

    @FXML
    public TableColumn<Cars,String> brand;

    private final CarService service = CarService.getInstance();

    @FXML
    public void initialize() {

        loadDate();
        BackButton.setOnMouseClicked(this::handle);

    }

    private void loadDate() {
        ObservableList<Cars> carsObservableList = service.getAllTask();


        idCar.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getCars_id()));
        model.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getIdMODEL().getModel_name()));
        colour.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getCars_color()));
        year.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getCars_year()));
        classCar.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getCars_class()));
       smoker.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getIdSMOKER().getSmoker_Type()));
       regNum.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getCars_reg_num()));
       brand.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getIdMODEL().getBrand().getBrand_name()));

        TableCars.setItems(carsObservableList);
    }

    @FXML
    private void handle(Event event) {
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
