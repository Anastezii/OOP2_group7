package bg.tu_varna.sit.carrent.business.services;

import bg.tu_varna.sit.carrent.data.entities.Admin;
import bg.tu_varna.sit.carrent.data.entities.Client;
import bg.tu_varna.sit.carrent.data.repositories.ClientRepository;
import bg.tu_varna.sit.carrent.data.repositories.UserRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class ClientService {

    private final ClientRepository repository= ClientRepository.getInstance();


    public static ClientService getInstance(){
        return  ClientService.ClientServiceHolder.INSTANCE;
    }

    private static class ClientServiceHolder {

        public static final ClientService INSTANCE = new ClientService();
    }

    public ObservableList<Client> getAllTask(String login,String pass){
        List<Client> clients=repository.getLogin(login,pass);
        return FXCollections.observableList(clients.stream().map(o->new Client(o.getCl_login(),
                o.getCl_password())).collect(Collectors.toList()));
    }

    public ObservableList<Client> getAllTaskTable(){
        List<Client> clients=repository.getAll();
        return FXCollections.observableList(clients.stream().map(o->new Client(o.getOper(), o.getCl_id(),
                o.getCl_login(), o.getCl_password())).collect(Collectors.toList()));
    }


}
