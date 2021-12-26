package bg.tu_varna.sit.carrent.business.services;

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

    public ObservableList<OperatorListViewModel> getAllTask(){
        List<Operator> operators=repository.getAll();
        return FXCollections.observableList(operators.stream().map(o->new OperatorListViewModel(o.getOperator_login(),o.getIdadministr().getAdmin_login())).collect(Collectors.toList()));
    }

}