package bg.tu_varna.sit.carrent.presentation.controlers;

import bg.tu_varna.sit.carrent.business.services.OperatorService;
import bg.tu_varna.sit.carrent.data.entities.Client;
import bg.tu_varna.sit.carrent.data.entities.Operator;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class OperatorLogin  {

    private final OperatorService service1 = OperatorService.getInstance();


    @FXML
    private TextField OperatorLogin;

    @FXML
    private PasswordField OperatorPassword;

    @FXML
    private Button buttonOperator;

   @FXML
    public void initialize() {
        buttonOperator.setOnMouseClicked(this::handle);}


  
    public void handle(Event event) {
        String loginOp = OperatorLogin.getText().trim();
        String passOp = OperatorPassword.getText().trim();
       Operator operator = new Operator(loginOp,passOp);
        //operator.setOperator_login(loginOp);
     //   operator.setOperator_password(passOp);
        ObservableList<Operator> allTask = service1.getAllTask(loginOp,passOp);

        boolean Login=false;

        for (Operator opLog:allTask) {
            if(operator.getOperator_login().equals(loginOp) &&
                    operator.getOperator_password().equals(passOp)){
                Login=true;
                System.out.println("True");
               extracted();
            }
            else{
                System.out.println("error in adm");
                Login=false;
            }
        }
    }

    private void extracted() {
        Parent root;
        try{
            URL pathOperWindow = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/OperatorWindow.fxml");
            root= FXMLLoader.load(pathOperWindow);
            Stage stage=new Stage();
            stage.setTitle("Operator Window");
            stage.setScene(new Scene(root));
            stage.show();
            //((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }
}
