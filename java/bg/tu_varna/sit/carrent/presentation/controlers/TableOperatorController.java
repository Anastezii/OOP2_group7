package bg.tu_varna.sit.carrent.presentation.controlers;

import bg.tu_varna.sit.carrent.business.services.OperatorService;
import bg.tu_varna.sit.carrent.business.services.PhirmaService;
import bg.tu_varna.sit.carrent.data.entities.Operator;
import bg.tu_varna.sit.carrent.data.entities.Phirma;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class TableOperatorController {
    @FXML
    public TableView<Operator> TableOper;
    @FXML
    public TableColumn<Operator,String> idoperator;
    @FXML
    public TableColumn<Operator,String> operLogin;
    @FXML
    public TableColumn<Operator,String> operPass;
    @FXML
    public TableColumn<Operator,String> admid;
    @FXML
    public Button ReturnButton;

    private final OperatorService service = OperatorService.getInstance();


    @FXML
    public void initialize() {

        loadDate();
        ReturnButton.setOnMouseClicked(this::handle);

    }

    private void loadDate() {
        ObservableList<Operator> opObservableList = service.getAllTaskTable();


       idoperator.setCellValueFactory(o->new ReadOnlyObjectWrapper(o.getValue().getOperator_id()));
        operLogin.setCellValueFactory(o->new ReadOnlyObjectWrapper(o.getValue().getOperator_login()));
        operPass.setCellValueFactory(o->new ReadOnlyObjectWrapper(o.getValue().getOperator_password()));
        admid.setCellValueFactory(o->new ReadOnlyObjectWrapper(o.getValue().getIdadministr().getAdmin_id()));

        TableOper.setItems(opObservableList);
    }

    private void handle(Event event) {
        Parent root;
        try{
            URL pathAdminLog = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/AdminWindow.fxml");
            root= FXMLLoader.load(pathAdminLog);
            Stage stage=new Stage();
            stage.setTitle("Admin Window");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }


}
