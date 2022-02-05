package bg.tu_varna.sit.carrent.data.repositories;

import bg.tu_varna.sit.carrent.data.entities.Client;
import bg.tu_varna.sit.carrent.data.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private  UserRepository userRepository;
    private  UserTypeRepository repositoryUserType;
    private  ClientRepository repositoryClient;

    @BeforeEach
    void setUp() {
        userRepository=new UserRepository();
        repositoryUserType=new UserTypeRepository();
        repositoryClient=new ClientRepository();
    }

    @Test
    void save() {

        User user=new User();
        user.setLogin("Shastun");
       user.setPassword("5214");
       user.setIduserType(repositoryUserType.getType("client"));
       user.setClient(repositoryClient.getClient("Nelly"));

       userRepository.save(user);

        Long id=user.getId();
        Assertions.assertNotNull(id);

        Assertions.assertEquals(9,userRepository.getAll().size());
        User newUser=userRepository.getById(id);

        Assertions.assertEquals("Shastun",newUser.getLogin());
        Assertions.assertEquals("5214",newUser.getPassword());
        Assertions.assertEquals("client",newUser.getIduserType().getUser_type_name());
        Assertions.assertEquals("Nelly",newUser.getClient().getCl_login());

    }

    @Test
    void getUser() {
    }
}