package bg.tu_varna.sit.carrent.presentation.controlers;

import bg.tu_varna.sit.carrent.business.services.PhirmaService;
import bg.tu_varna.sit.carrent.data.entities.Phirma;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class TablePhirma {
    @FXML
    public TableView<Phirma> TablePhirma;
    @FXML
    public Button ButtonReturn;
    @FXML
    public TableColumn<Phirma,String> phId;
    @FXML
    public TableColumn<Phirma,String> Name;
    @FXML
    public TableColumn<Phirma,String> idAdmin;

    private final PhirmaService service = PhirmaService.getInstance();

    @FXML
    public void initialize() {

        loadDate();
        ButtonReturn.setOnMouseClicked(this::handle);

    }

    private void loadDate() {

        ObservableList<Phirma> phirmaObservableList = service.getAllTask();


       phId.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getPh_id()));
        Name.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getPh_name()));
        idAdmin.setCellValueFactory(p->new ReadOnlyObjectWrapper(p.getValue().getIdad().getAdmin_login()));

        TablePhirma.setItems(phirmaObservableList);
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
