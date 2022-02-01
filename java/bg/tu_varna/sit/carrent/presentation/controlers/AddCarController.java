package bg.tu_varna.sit.carrent.presentation.controlers;

import bg.tu_varna.sit.carrent.business.services.CarService;
import bg.tu_varna.sit.carrent.business.services.OperatorService;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AddCarController {
    @FXML
    public Button AddCarButton;
    @FXML
    public TextField Model;
    @FXML
    public TextField Color;
    @FXML
    public TextField year;
    @FXML
    public TextField Class;
    @FXML
    public TextField Smoker;
    @FXML
    public TextField RegNum;
    @FXML
    public TextField Brand;
    @FXML
    public Button BackButton;
    @FXML
    public Button TableButton;


    private final CarService service = CarService.getInstance();


    @FXML
    public void initialize() {
       AddCarButton.setOnMouseClicked(this::handle);
        BackButton.setOnMouseClicked(this::handle1);
        TableButton.setOnMouseClicked(this::handle2);

    }
    public void handle(Event event) {
        String model = Model.getText().trim();
        String color=Color.getText().trim();
        String Year =year.getText().trim();
        String classCar=Class.getText().trim();
        String smoker=Smoker.getText().trim();
        String regNum=RegNum.getText().trim();
        String brand=Brand.getText().trim();

        service.SaveCar(model,color,Year,classCar,smoker,regNum,brand);
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
    public void handle2(Event event) {
        Parent root;
        try{
            URL pathCar = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/TableViewCars.fxml");
            root= FXMLLoader.load(pathCar);
            Stage stage=new Stage();
            stage.setTitle("Table Cars");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }
}
