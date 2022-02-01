package bg.tu_varna.sit.carrent.presentation.controlers;

import bg.tu_varna.sit.carrent.business.services.PhirmaService;
import bg.tu_varna.sit.carrent.business.services.RentService;
import bg.tu_varna.sit.carrent.data.entities.Phirma;
import bg.tu_varna.sit.carrent.data.entities.Rent;
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

public class TableRentController {
    @FXML
    public TableView<Rent> RentTable;
    @FXML
    public TableColumn<Rent, String> rentId;
    @FXML
    public TableColumn<Rent, String> dateStart;
    @FXML
    public TableColumn<Rent, String> endDate;
    @FXML
    public TableColumn<Rent, String> logOp;
    @FXML
    public TableColumn<Rent, String> logCl;
    @FXML
    public TableColumn<Rent, String> phName;
    @FXML
    public TableColumn<Rent, String> idCars;
    @FXML
    public TableColumn<Rent, String> CarRegNum;
    @FXML
    public Button ReturnButton;

    private final RentService service = RentService.getInstance();
    @FXML
    public TableColumn<Rent, String> Carkm;

    @FXML
    public void initialize() {

        loadDate();
        ReturnButton.setOnMouseClicked(this::handle);

    }

    private void loadDate() {
        ObservableList<Rent> rentObservableList = service.getAllTask();


        rentId.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getRent_id()));
        dateStart.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getRent_date()));
       endDate.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getRent_date_end()));
       logOp.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getIdoper().getOperator_login()));
       logCl.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getIdcl().getCl_login()));
        phName.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getIdph().getPh_name()));
       idCars.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getIdCARS().getCars_reg_num()));
       CarRegNum.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getIdCARS().getCars_reg_num()));
       Carkm.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getKm()));

        RentTable.setItems(rentObservableList);
    }

    @FXML
    private void handle(Event event) {
        Parent root;
        try{
            URL pathop = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/OperatorWindow.fxml");
            root= FXMLLoader.load(pathop);
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
