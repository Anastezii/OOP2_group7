package bg.tu_varna.sit.carrent.data.repositories;

import bg.tu_varna.sit.carrent.data.entities.Cars;
import bg.tu_varna.sit.carrent.data.entities.Phirma;
import bg.tu_varna.sit.carrent.data.entities.Rent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class RentRepositoryTest {

    private  RentRepository repositoryRent;
    private  CarsRepository repositoryCars;
    private  PhirmaRepository repositoryPhirma;
    private  ClientRepository repositoryClient;
    private  OperatorRepository repositoryOperator;

    @BeforeEach
    void setUp() {
        repositoryRent=new RentRepository();
        repositoryCars=new CarsRepository();
        repositoryPhirma=new PhirmaRepository();
        repositoryClient=new ClientRepository();
        repositoryOperator=new OperatorRepository();
    }

    @Test
    void save() {

        Rent rent =new Rent();
       rent.setRent_date(LocalDate.of(2022,02,12));
       rent.setRent_date_end(LocalDate.of(2022,03,3));
       rent.setKm("32574");
       rent.setIdoper(repositoryOperator.getOperator("Nax"));
       rent.setIdcl(repositoryClient.getClient("Elena"));
       rent.setIdph(repositoryPhirma.getPhirma("Pozhar"));
       rent.setIdCARS(repositoryCars.getCars("CT 6767 B"));


        repositoryRent.save(rent);

        Long id=rent.getRent_id();
        Assertions.assertNotNull(id);

        Assertions.assertEquals(7,repositoryRent.getAll().size());
        Rent newRent=repositoryRent.getById(id);

        Assertions.assertEquals(LocalDate.of(2022,02,12),newRent.getRent_date());
        Assertions.assertEquals(LocalDate.of(2022,03,3),newRent.getRent_date_end());
        Assertions.assertEquals("32574",newRent.getKm());
        Assertions.assertEquals("Nax",newRent.getIdoper().getOperator_login());
        Assertions.assertEquals("Elena",newRent.getIdcl().getCl_login());
        Assertions.assertEquals("Pozhar",newRent.getIdph().getPh_name());
        Assertions.assertEquals("CT 6767 B",newRent.getIdCARS().getCars_reg_num());

    }


    @Test
    void delete() {

        Rent rent =new Rent();
       rent.setRent_id(7L);

       repositoryRent.delete(rent);

        Assertions.assertEquals(7,repositoryRent.getAll().size());


    }


}