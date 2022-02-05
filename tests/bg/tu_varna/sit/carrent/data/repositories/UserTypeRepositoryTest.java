package bg.tu_varna.sit.carrent.data.repositories;

import bg.tu_varna.sit.carrent.data.entities.Client;
import bg.tu_varna.sit.carrent.data.entities.UserType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTypeRepositoryTest {

    private  UserTypeRepository repositoryUserType;

    @BeforeEach
    void setUp() {
        repositoryUserType=new UserTypeRepository();
    }

    @Test
    void getType() {

        UserType userType =repositoryUserType.getType("admin");
        Assertions.assertEquals("admin",userType.getUser_type_name());

    }
}