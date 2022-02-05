package bg.tu_varna.sit.carrent.data.repositories;

import bg.tu_varna.sit.carrent.data.entities.Client;
import bg.tu_varna.sit.carrent.data.entities.Smoker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmokerRepositoryTest {

    private  SmokerRepository repositorySmoker;

    @BeforeEach
    void setUp() {
        repositorySmoker=new SmokerRepository();
    }

    @Test
    void getSmoker() {

        Smoker smoker =repositorySmoker.getSmoker("y");
        Assertions.assertEquals("y",smoker.getSmoker_Type());

    }
}