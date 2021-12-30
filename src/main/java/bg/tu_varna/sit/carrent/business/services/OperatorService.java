package bg.tu_varna.sit.carrent.business.services;

import bg.tu_varna.sit.carrent.data.entities.Admin;
import bg.tu_varna.sit.carrent.data.entities.Operator;
import bg.tu_varna.sit.carrent.data.repositories.OperatorRepository;
import bg.tu_varna.sit.carrent.presentation.models.OperatorListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class OperatorService {

    private final OperatorRepository repository= OperatorRepository.getInstance();


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

}