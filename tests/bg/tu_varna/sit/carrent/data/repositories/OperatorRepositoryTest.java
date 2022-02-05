package bg.tu_varna.sit.carrent.data.repositories;

import bg.tu_varna.sit.carrent.data.entities.Client;
import bg.tu_varna.sit.carrent.data.entities.Operator;
import bg.tu_varna.sit.carrent.data.entities.Phirma;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorRepositoryTest {

    private OperatorRepository operatorRepository;
    private  AdminRepository repository1;

    @BeforeEach
    void setUp() {
        operatorRepository=new OperatorRepository();
        repository1=new AdminRepository();
    }


    @Test
    void save() {

        Operator operator=new Operator();
       operator.setOperator_login("Arien Arnaut");
       operator.setOperator_password("2632455");
        operator.setIdadministr(repository1.getAdmin("ad"));

       operatorRepository.save(operator);

        Long id=operator.getOperator_id();
        Assertions.assertNotNull(id);

        Assertions.assertEquals(12,operatorRepository.getAll().size());
       Operator newOperator=operatorRepository.getById(id);

        Assertions.assertEquals("Arien Arnaut",newOperator.getOperator_login());
        Assertions.assertEquals("2632455",newOperator.getOperator_password());
        Assertions.assertEquals("ad",newOperator.getIdadministr().getAdmin_login());
    }

    @Test
    void getOperator() {

        Operator operator=operatorRepository.getOperator("Daniel Aleksov");
        Assertions.assertEquals("Daniel Aleksov",operator.getOperator_login());
        Assertions.assertEquals("2147859",operator.getOperator_password());
        Assertions.assertEquals("ad",operator.getIdadministr().getAdmin_login());

    }
}