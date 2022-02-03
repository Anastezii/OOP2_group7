package bg.tu_varna.sit.carrent.presentation.controlers;

import bg.tu_varna.sit.carrent.business.services.CarService;
import bg.tu_varna.sit.carrent.business.services.ClientService;
import bg.tu_varna.sit.carrent.business.services.PhirmaService;
import bg.tu_varna.sit.carrent.business.services.RentService;
import bg.tu_varna.sit.carrent.data.entities.Phirma;
import bg.tu_varna.sit.carrent.data.entities.Rent;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;


public class AddRentController {



    @FXML
    public Button RentButton;
    @FXML
    public Button BackButton;
    @FXML
    public Button TableButton;

    @FXML
    public DatePicker StartDate;
    @FXML
    public DatePicker EndDate;
    @FXML
    public TextField CarText;
    @FXML
    public TextField ClientText;
    @FXML
    public TextField PhirmaText;
    @FXML
    public TextField kmBefore;
    @FXML
    public TextField OperatorText;

    private final RentService service = RentService.getInstance();

    // private final ClientService serviceClient =ClientService.getInstance();
   // private final PhirmaService serviceCompany = PhirmaService.getInstance();
   // private final CarService serviceCars = CarService.getInstance();



    @FXML
    public void initialize() {

        RentButton.setOnMouseClicked(this::handle);
        BackButton.setOnMouseClicked(this::handle1);
        TableButton.setOnMouseClicked(this::handle2);
    }



    public void handle(Event event) {
     LocalDate startDateRent=StartDate.getValue();
       LocalDate endDateRent=EndDate.getValue();
       String carName=CarText.getText().trim();
       String companyName=PhirmaText.getText().trim();
       String clientName=ClientText.getText().trim();
       String kmBeforeRent=kmBefore.getText().trim();
       String operatorName=OperatorText.getText().trim();
       if(!service.SaveRent(startDateRent,endDateRent,carName,companyName,clientName,kmBeforeRent,operatorName)){
           return ;
       }

       String startDateRt=StartDate.getValue().toString();
       String endDateRt=EndDate.getValue().toString();
       saveToFile( startDateRt,endDateRt,carName,companyName,clientName,kmBeforeRent,operatorName);

       infoboxRent();
    }

    private void saveToFile(String startDateRt, String endDateRt, String carName,
                            String companyName, String clientName, String kmBeforeRent, String operatorName) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("RentCars.txt"));
            out.writeObject("Start of lease : "+startDateRt +" End of lease : " + endDateRt +" Car Reg Number : "+ carName + " Company name : "+
                    companyName + " Client name :  " + clientName +" km of car before rent : " +kmBeforeRent +" Name of operator : "+operatorName +"  ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void infoboxRent() {
        Stage dialogStage=new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        VBox vBox=new VBox(new Text("Succesfully added rent"),new Button("Ok"));
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
            URL pathOpWind = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/TableViewRent.fxml");
            root= FXMLLoader.load(pathOpWind);
            Stage stage=new Stage();
            stage.setTitle("Rent Table");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }
}
