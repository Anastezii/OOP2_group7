package bg.tu_varna.sit.carrent.data.repositories;

import bg.tu_varna.sit.carrent.data.entities.Admin;
import bg.tu_varna.sit.carrent.data.entities.Client;
import bg.tu_varna.sit.carrent.data.entities.Operator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientRepositoryTest {

    private  ClientRepository repository;
    private  OperatorRepository repositoryOperator;

    @BeforeEach
    void setUp() {
        repository=new ClientRepository();
        repositoryOperator=new OperatorRepository();
    }

    @Test
    void save() {

        Client client=new Client();
       client.setCl_login("Arina Nakivannaya");
        client.setCl_password("521478");
       client.setOper(repositoryOperator.getOperator("Kelly"));

        repository.save(client);

        Long id=client.getCl_id();
        Assertions.assertNotNull(id);

        Assertions.assertEquals(6,repository.getAll().size());
       Client newClient=repository.getById(id);

        Assertions.assertEquals("Arina Nakivannaya",newClient.getCl_login());
        Assertions.assertEquals("521478",newClient.getCl_password());
        Assertions.assertEquals("Kelly",newClient.getOper().getOperator_login());

    }



    @Test
    void getClient() {
        Client client=repository.getClient("Nelly");
        Assertions.assertEquals("Nelly",client.getCl_login());
        Assertions.assertEquals("2546",client.getCl_password());
        Assertions.assertEquals("op",client.getOper().getOperator_login());
    }
}