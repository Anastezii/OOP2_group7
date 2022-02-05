package bg.tu_varna.sit.carrent.data.repositories;

import bg.tu_varna.sit.carrent.data.entities.Admin;
import bg.tu_varna.sit.carrent.data.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminRepositoryTest {

    private AdminRepository  repositoryAdmin;

    @BeforeEach
    void setUp() {
        repositoryAdmin=new AdminRepository();
    }


    @Test
    void getAdmin() {
       Admin admin=repositoryAdmin.getAdmin("ad");
       Assertions.assertEquals("ad",admin.getAdmin_login());
       Assertions.assertEquals("1",admin.getAdmin_password());
    }
}