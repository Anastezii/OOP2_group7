package bg.tu_varna.sit.carrent.presentation.controlers;

import bg.tu_varna.sit.carrent.business.services.OperatorService;
import bg.tu_varna.sit.carrent.business.services.PhirmaService;
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


public class AddOperatorController {

    private final OperatorService service = OperatorService.getInstance();
    private final UserService serviceUser = UserService.getInstance();

    @FXML
    public TextField Operatorlogin;
    @FXML
    public TextField OperatorPass;
    @FXML
    public Button AddOperator;
    @FXML
    public Button BackButton;
    @FXML
    public Button TableButton;
    @FXML
    public TextField AdminName;
    @FXML
    public TextField UserName;
    @FXML
    public TextField UserPass;

    @FXML
    public void initialize() {
        AddOperator.setOnMouseClicked(this::handle);
        BackButton.setOnMouseClicked(this::handle1);
        TableButton.setOnMouseClicked(this::handle2);
    }
    public void handle(Event event) {
        boolean Save=false;
        String opLogin = Operatorlogin.getText().trim();
        String opPass=OperatorPass.getText().trim();
        String admin =AdminName.getText().trim();
        String username=UserName.getText().trim();
        String userpass=UserPass.getText().trim();
        service.SaveOperator(opLogin,opPass,admin);
        serviceUser.SaveOperator(username,userpass,opLogin);
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
        VBox vBox=new VBox(new Text("Succesfully saved operator"),new Button("Ok"));
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(30));
        dialogStage.setScene(new Scene(vBox));
        dialogStage.showAndWait();


    }

    public void handle2(Event event) {
        Parent root;
        try{
            URL pathAdminLog = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/TableViewOperator.fxml");
            root= FXMLLoader.load(pathAdminLog);
            Stage stage=new Stage();
            stage.setTitle("Table Operator");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }

}
