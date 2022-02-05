package bg.tu_varna.sit.carrent.business.services;

import bg.tu_varna.sit.carrent.data.entities.*;
import bg.tu_varna.sit.carrent.data.repositories.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class RentService {

    private final RentRepository repository= RentRepository.getInstance();
    private final CarsRepository repositoryCars= CarsRepository.getInstance();
    private final PhirmaRepository repositoryPhirma= PhirmaRepository.getInstance();
    private final ClientRepository repositoryClient= ClientRepository.getInstance();
    private final OperatorRepository repositoryOperator= OperatorRepository.getInstance();


    public static RentService getInstance(){
        return RentService.RentServiceHolder.INSTANCE;
    }

    private static class RentServiceHolder {

        public static final RentService INSTANCE = new RentService();
    }

    public ObservableList<Rent> getAllTask( ){
        List<Rent> rents=repository.getAll();
        return FXCollections.observableList(rents.stream().map(o->new Rent(o.getRent_id(),o.getRent_date(),o.getRent_date_end(),
                        o.getIdCARS(),o.getIdoper(),o.getIdcl(),o.getIdph(),o.getKm())).
                collect(Collectors.toList()));

    }

    public boolean SaveRent(LocalDate dateStartRent, LocalDate dateEndRent, String CarRegNum,
                         String PhirmaName, String ClientName, String kmBeforeRent, String operatorName ){

      Rent rent=new Rent();
      rent.setKm(kmBeforeRent);
      rent.setRent_date(dateStartRent);
      rent.setRent_date_end(dateEndRent);


      Cars carsReg=repositoryCars.getCars(CarRegNum);
        if(carsReg==null){
            infoboxCar();
            return false;
        }
        else{
            rent.setIdCARS(carsReg);

        }

        Phirma phirmaNameRent=repositoryPhirma.getPhirma(PhirmaName);
        if(phirmaNameRent==null){
            infoboxCompany();
            return false;
        }else{
            rent.setIdph(phirmaNameRent);

        }

        Client clientForRent=repositoryClient.getClient(ClientName);
        if(clientForRent==null){
            infoboxClient();
            return false;
        }else{
            rent.setIdcl(clientForRent);

        }

        Operator operatorNameRent=repositoryOperator.getOperator(operatorName);
        if(operatorNameRent==null){
            infoboxOperator();
            return false;
        }else{
            rent.setIdoper(operatorNameRent);

        }

        try{
            repository.save(rent);}
        catch(Exception ex ){
            ex.getCause();
        }
        return true;

    }

    private void infoboxOperator() {
        Stage dialogStage=new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        VBox vBox=new VBox(new Text("Not correct operator name please check your input."),new Button("Ok"));
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(30));
        dialogStage.setScene(new Scene(vBox));
        dialogStage.showAndWait();
    }

    private void infoboxClient() {
        Stage dialogStage=new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        VBox vBox=new VBox(new Text("Not correct client name please check your input."),new Button("Ok"));
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(30));
        dialogStage.setScene(new Scene(vBox));
        dialogStage.showAndWait();
    }

    private void infoboxCompany() {
        Stage dialogStage=new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        VBox vBox=new VBox(new Text("Not correct company name please check your input."),new Button("Ok"));
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(30));
        dialogStage.setScene(new Scene(vBox));
        dialogStage.showAndWait();
    }

    private void infoboxCar() {
        Stage dialogStage=new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        VBox vBox=new VBox(new Text("Not correct car reg number please check your input."),new Button("Ok"));
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(30));
        dialogStage.setScene(new Scene(vBox));
        dialogStage.showAndWait();
    }

    public boolean CheckRent(LocalDate dateStartRent, LocalDate dateEndRent, String CarRegNum,
                           String ClientName){

           if( repository.CheckRent(dateStartRent,dateEndRent)==null){
               infoboxDate();
               return false;
           }

        Cars carsReg=repositoryCars.getCars(CarRegNum);
        if(carsReg==null){
            infoboxCar();
            return false;
        }

        Client clientForRent=repositoryClient.getClient(ClientName);
        if(clientForRent==null){
            infoboxClient();
            return false;
        }


           return true;
    }

    private void infoboxDate() {
        Stage dialogStage=new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        VBox vBox=new VBox(new Text("Not correct date of begin or end of lease please check your input."),new Button("Ok"));
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(30));
        dialogStage.setScene(new Scene(vBox));
        dialogStage.showAndWait();
    }

}
