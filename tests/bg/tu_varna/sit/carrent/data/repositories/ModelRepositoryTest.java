package bg.tu_varna.sit.carrent.data.repositories;

import bg.tu_varna.sit.carrent.data.entities.Client;
import bg.tu_varna.sit.carrent.data.entities.Model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelRepositoryTest {

    private  ModelRepository repositoryModel;

    @BeforeEach
    void setUp() {
        repositoryModel=new ModelRepository();

    }

    @Test
    void save() {

        Model model=new Model();
       model.setModel_name("Huracan");

        repositoryModel.save(model);

        Long id=model.getModel_id();
        Assertions.assertNotNull(id);

        Assertions.assertEquals(10,repositoryModel.getAll().size());
        Model newModel=repositoryModel.getById(id);

        Assertions.assertEquals("Huracan",newModel.getModel_name());

    }

    @Test
    void getModel() {


        Model model=repositoryModel.getModel("Urus");
        Assertions.assertEquals("Urus",model.getModel_name());

    }
}