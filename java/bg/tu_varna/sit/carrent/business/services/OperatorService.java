package bg.tu_varna.sit.carrent.business.services;

import bg.tu_varna.sit.carrent.data.entities.Admin;
import bg.tu_varna.sit.carrent.data.entities.Operator;
import bg.tu_varna.sit.carrent.data.entities.Phirma;
import bg.tu_varna.sit.carrent.data.entities.User;
import bg.tu_varna.sit.carrent.data.repositories.AdminRepository;
import bg.tu_varna.sit.carrent.data.repositories.OperatorRepository;
import bg.tu_varna.sit.carrent.presentation.models.OperatorListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class OperatorService {

    private final OperatorRepository repository= OperatorRepository.getInstance();
    private final AdminRepository repositoryAdmin= AdminRepository.getInstance();



    public static OperatorService getInstance(){
        return  OperatorService.OperatorServiceHolder.INSTANCE;
    }

    private static class OperatorServiceHolder {

        public static final OperatorService INSTANCE = new OperatorService();
    }

    public ObservableList<Operator> getAllTask(String login,String pass){
        List<Operator> operators=repository.getLogin(login,pass);
        return FXCollections.observableList(operators.stream().map(o->new Operator(o.getOperator_login(),
                o.getOperator_password())).collect(Collectors.toList()));
    }

    public ObservableList<Operator> getAllTaskTable(){
        List<Operator> operators=repository.getAll();
        return FXCollections.observableList(operators.stream().map(o->new Operator(o.getOperator_id(),o.getOperator_login(),
                o.getOperator_password(),o.getIdadministr())).collect(Collectors.toList()));
    }


    public void SaveOperator(String opName,String opPass,String AdminName){
       Operator operator=new Operator();
        operator.setOperator_login(opName);
        operator.setOperator_password(opPass);
        operator.setIdadministr(repositoryAdmin.getAdmin(AdminName));
        repository.save(operator);

    }

}