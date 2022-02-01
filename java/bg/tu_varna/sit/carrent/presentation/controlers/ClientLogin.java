package bg.tu_varna.sit.carrent.presentation.controlers;

import bg.tu_varna.sit.carrent.business.services.ClientService;
import bg.tu_varna.sit.carrent.business.services.UserService;
import bg.tu_varna.sit.carrent.data.entities.Admin;
import bg.tu_varna.sit.carrent.data.entities.Client;
import bg.tu_varna.sit.carrent.data.entities.User;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ClientLogin {

    private final ClientService service2 = ClientService.getInstance();
    private final UserService serviceUser = UserService.getInstance();


    @FXML
    public TextField ClientLogins;



    @FXML
    private PasswordField ClientPassword;

    @FXML
    private Button button;

    @FXML
    public void initialize() {
        button.setOnMouseClicked(this::handle);
    }

    public void handle(Event event) {

        String loginCl = ClientLogins.getText().trim();
        String passCl = ClientPassword.getText().trim();
        User client = new User(loginCl,passCl);
       // client.setCl_login(loginCl);
      // client.setCl_password(passCl);
        ObservableList<User> allTask = serviceUser.getAllTask(loginCl,passCl);

        boolean Login=false;

        for (User clLog:allTask) {
            if(client.getLogin().equals(loginCl) && client.getPassword().equals(passCl)){
                Login=true;
                System.out.println("True");
                button.setOnMouseClicked(this::extracted);
            }
            else{
                System.out.println("error in adm");
                Login=false;
            }
        }

       /* if(ClientLogins instanceof ObservableList<?>){
            for (Object o:(ObservableList<?>)ClientLogins) {
                if(o instanceof Client){
                    if(ClientPassword instanceof ObservableList<?>){
                        for (Object obj: (ObservableList<?>)ClientPassword){
                            if (obj instanceof Client){
                                allTask.add((Client)o);
                                allTask.add((Client) obj);
                                Login=true;
                                button.setOnAction(this::extracted);
                            }
                        }
                    }
                }
            }
        }else{
            System.out.println("Don`t exist this admin login or pass");
            Login=false;
        }*/

    }

    private void extracted(MouseEvent mouseEvent) {
        Parent root;
        try{
            URL pathClWindow = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/ClientWindow.fxml");
            root= FXMLLoader.load(pathClWindow);
            Stage stage=new Stage();
            stage.setTitle("Client Window");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }


}

