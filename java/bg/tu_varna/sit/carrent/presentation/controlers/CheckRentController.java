package bg.tu_varna.sit.carrent.presentation.controlers;

import bg.tu_varna.sit.carrent.business.services.RentService;
import bg.tu_varna.sit.carrent.data.entities.Phirma;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;

public class CheckRentController {
    @FXML
    public TextField InputLogin;

    @FXML
    public TextField CarRent;
    @FXML
    public Button CheckRent;
    @FXML
    public Button BackButton;
    @FXML
    public DatePicker Start;
    @FXML
    public DatePicker End;

    private final RentService service = RentService.getInstance();

    @FXML
    public void initialize() {
        CheckRent.setOnMouseClicked(this::handle);
        BackButton.setOnMouseClicked(this::handle1);
    }
    public void handle(Event event) {
        String ClientName=InputLogin.getText().trim();
        String CarRegNum=CarRent.getText().trim();
        LocalDate startDateRent=Start.getValue();
        LocalDate endDateRent=End.getValue();
       if(!service.CheckRent(startDateRent,endDateRent,CarRegNum,ClientName)){return;}
        infobox();
    }

    private void infobox() {
        Stage dialogStage=new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        VBox vBox=new VBox(new Text("Your rent is valid."),new Button("Ok"));
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(30));
        dialogStage.setScene(new Scene(vBox));
        dialogStage.showAndWait();
    }

    public void handle1(Event event) {
        Parent root;
        try{
            URL pathClientLog = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/ClientWindow.fxml");
            root= FXMLLoader.load(pathClientLog);
            Stage stage=new Stage();
            stage.setTitle("Client Window");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }



}
