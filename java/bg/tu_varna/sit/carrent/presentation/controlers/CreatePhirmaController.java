package bg.tu_varna.sit.carrent.presentation.controlers;

import bg.tu_varna.sit.carrent.business.services.AdminService;
import bg.tu_varna.sit.carrent.business.services.PhirmaService;
import bg.tu_varna.sit.carrent.data.entities.Admin;
import bg.tu_varna.sit.carrent.data.entities.Phirma;
import bg.tu_varna.sit.carrent.data.repositories.PhirmaRepository;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;



public class CreatePhirmaController {

    private final PhirmaService service = PhirmaService.getInstance();
    private final AdminService serviceAdmin = AdminService.getInstance();


@FXML
    public TextField ComponyName;
    @FXML
    public Button CreatePhirma;
    @FXML
    public Button BackButton;
    @FXML
    public Button TableViewButton;
    @FXML
    public TextField username;


    @FXML
    public void initialize() {

        CreatePhirma.setOnMouseClicked(this::handle);
        BackButton.setOnMouseClicked(this::handle1);
        TableViewButton.setOnMouseClicked(this::handle2);
    }
    public void handle(Event event) {

        String phirma = ComponyName.getText().trim();
        String adminName=username.getText().trim();
        service.SavePhirma(phirma,adminName);


        infobox();
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
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }

    public void infobox(){
        Stage dialogStage=new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        VBox vBox=new VBox(new Text("Succesfully saved compony"),new Button("Ok"));
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(30));
        dialogStage.setScene(new Scene(vBox));
        dialogStage.showAndWait();


    }

    public void handle2(Event event) {
        Parent root;
        try{
            URL pathAdminLog = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/TableViewPhirma.fxml");
            root= FXMLLoader.load(pathAdminLog);
            Stage stage=new Stage();
            stage.setTitle("Table View Company");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }


}
