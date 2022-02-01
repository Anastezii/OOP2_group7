package bg.tu_varna.sit.carrent.presentation.controlers;

import bg.tu_varna.sit.carrent.business.services.ClientService;
import bg.tu_varna.sit.carrent.business.services.OperatorService;
import bg.tu_varna.sit.carrent.business.services.UserService;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AddClientController {
    @FXML
    public TextField ClientLogin;
    @FXML
    public TextField ClientPass;
    @FXML
    public Button AddClient;
    @FXML
    public Button BackButton;
    @FXML
    public Button TableButton;
    @FXML
    public TextField OperatorName;

    private final ClientService service = ClientService.getInstance();
    private final UserService serviceUser = UserService.getInstance();
    @FXML
    public TextField UserName;
    @FXML
    public TextField UserPass;

    @FXML
    public void initialize() {
        AddClient.setOnMouseClicked(this::handle);
        BackButton.setOnMouseClicked(this::handle1);
        TableButton.setOnMouseClicked(this::handle2);
    }
    public void handle(Event event) {
        boolean Save=false;
        String clLogin = ClientLogin.getText().trim();
        String clPass=ClientPass.getText().trim();
        String operator =OperatorName.getText().trim();
        String username=UserName.getText().trim();
        String userpass=UserPass.getText().trim();
        service.SaveClient(clLogin,clPass,operator);
        serviceUser.SaveClient(username,userpass,clLogin);
        infobox();
    }

    private void infobox() {

        Stage dialogStage=new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        VBox vBox=new VBox(new Text("Succesfully saved operator"),new Button("Ok"));
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(30));
        dialogStage.setScene(new Scene(vBox));
        dialogStage.showAndWait();


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
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }

    public void handle2(Event event) {
        Parent root;
        try{
            URL pathTable = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/TableViewClient.fxml");
            root= FXMLLoader.load(pathTable);
            Stage stage=new Stage();
            stage.setTitle("Clent Table");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }

}
