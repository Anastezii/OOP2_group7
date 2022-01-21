package bg.tu_varna.sit.carrent.business.services;

import bg.tu_varna.sit.carrent.data.entities.Operator;
import bg.tu_varna.sit.carrent.data.repositories.OperatorRepository;
import bg.tu_varna.sit.carrent.data.repositories.UserRepository;
import bg.tu_varna.sit.carrent.presentation.models.OperatorListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository repository= UserRepository.getInstance();


    public static UserService getInstance(){
        return  UserService.UserServiceHolder.INSTANCE;
    }

    private static class UserServiceHolder {

        public static final UserService INSTANCE = new UserService();
    }

   /* public ObservableList<UserListViewModel> getAllTask(){
        List<User> users=repository.getAll();
        return 0;
    }*/

}
