package bg.tu_varna.sit.carrent.presentation.controlers;

import bg.tu_varna.sit.carrent.business.services.ClientService;
import bg.tu_varna.sit.carrent.business.services.PhirmaService;
import bg.tu_varna.sit.carrent.data.entities.Client;
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

public class TableClientConroller {
    @FXML
    public TableView<Client> TableClient;
    @FXML
    public TableColumn<Client,String> idCl;
    @FXML
    public TableColumn<Client,String> clName;
    @FXML
    public TableColumn<Client,String> clPass;
    @FXML
    public TableColumn<Client,String> opId;
    @FXML
    public Button ReturnButton;

    private final ClientService service = ClientService.getInstance();

    @FXML
    public void initialize() {

        loadDate();
        ReturnButton.setOnMouseClicked(this::handle);

    }

    private void loadDate() {

        ObservableList<Client> clObservableList = service.getAllTaskTable();


        idCl.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getCl_id()));
        clName.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getCl_login()));
        clPass.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getCl_password()));
        opId.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getOper().getOperator_id()));

        TableClient.setItems(clObservableList);
    }

    @FXML
    private void handle(Event event) {
        Parent root;
        try{
            URL pathOpWind = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/OperatorWindow.fxml");
            root= FXMLLoader.load(pathOpWind);
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
