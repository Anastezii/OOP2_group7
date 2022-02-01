package bg.tu_varna.sit.carrent.business.services;

import bg.tu_varna.sit.carrent.data.entities.Admin;
import bg.tu_varna.sit.carrent.data.entities.Operator;
import bg.tu_varna.sit.carrent.data.entities.User;
import bg.tu_varna.sit.carrent.data.repositories.ClientRepository;
import bg.tu_varna.sit.carrent.data.repositories.OperatorRepository;
import bg.tu_varna.sit.carrent.data.repositories.UserRepository;
import bg.tu_varna.sit.carrent.data.repositories.UserTypeRepository;
import bg.tu_varna.sit.carrent.presentation.models.OperatorListViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository repository= UserRepository.getInstance();
    private final UserTypeRepository repositoryUserType= UserTypeRepository.getInstance();
    private final OperatorRepository repositoryOperator= OperatorRepository.getInstance();
    private final ClientRepository repositoryClient= ClientRepository.getInstance();


    public static UserService getInstance(){
        return  UserService.UserServiceHolder.INSTANCE;
    }

    private static class UserServiceHolder {

        public static final UserService INSTANCE = new UserService();
    }

    public ObservableList<User> getAllTask(String login, String pass){
        List<User> admins=repository.getLoginAdmin(login,pass);
        return FXCollections.observableList(admins.stream().map(o->new User(o.getPassword(),
                o.getLogin())).collect(Collectors.toList()));
    }

   /* public ObservableList<UserListViewModel> getAllTask(){
        List<User> users=repository.getAll();
        return 0;
    }*/



    public void SaveOperator(String UserName,String UserPass,String operator){
        User user=new User();
        String userType="operator";
        user.setLogin(UserName);
        user.setPassword(UserPass);
        user.setOperator(repositoryOperator.getOperator(operator));
        user.setIduserType(repositoryUserType.getType(userType));
        repository.save(user);

    }

    public void SaveClient(String UserName,String UserPass,String client){
        User user=new User();
        String userType="client";
        user.setLogin(UserName);
        user.setPassword(UserPass);
        user.setClient(repositoryClient.getClient(client));
        user.setIduserType(repositoryUserType.getType(userType));
        repository.save(user);

    }

    public ObservableList<User> getAllTaskTable(){
        List<User> users=repository.getAll();
        return FXCollections.observableList(users.stream().map(o->new User(o.getLogin(),o.getPassword(),
                o.getIduserType(),o.getAdmin(),o.getOperator(),o.getClient())).collect(Collectors.toList()));
    }

}
