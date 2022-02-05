package bg.tu_varna.sit.carrent.data.repositories;

import bg.tu_varna.sit.carrent.data.entities.Client;
import bg.tu_varna.sit.carrent.data.entities.Phirma;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhirmaRepositoryTest {

    private PhirmaRepository phirmaRepository;
    private  AdminRepository repository1;
    @BeforeEach
    void setUp() {
        phirmaRepository=new PhirmaRepository();
        repository1=new AdminRepository();
    }

    @Test
    void save() {
        Phirma phirma=new Phirma();
        phirma.setPh_name("Lilush");
        phirma.setIdad(repository1.getAdmin("adm"));

        phirmaRepository.save(phirma);

        Long id=phirma.getPh_id();
        Assertions.assertNotNull(id);

        Assertions.assertEquals(9,phirmaRepository.getAll().size());
        Phirma newPhirma=phirmaRepository.getById(id);

        Assertions.assertEquals("Lilush",newPhirma.getPh_name());
        Assertions.assertEquals("adm",newPhirma.getIdad().getAdmin_login());


    }

    @Test
    void update() {

        Phirma phirma=new Phirma();
        phirma.setPh_name("Mrak");
        phirma.setIdad(repository1.getAdmin("adm"));

        phirmaRepository.save(phirma);
        phirma.setPh_name("Msk");
        phirmaRepository.update(phirma);

        Long id=phirma.getPh_id();
        Assertions.assertNotNull(id);

        Assertions.assertEquals(8,phirmaRepository.getAll().size());
        Phirma newPhirma=phirmaRepository.getById(id);

        Assertions.assertEquals("Msk",newPhirma.getPh_name());
        Assertions.assertEquals("adm",newPhirma.getIdad().getAdmin_login());

    }

    @Test
    void delete() {

        Phirma phirma=new Phirma();
        phirma.setPh_id(6L);

        phirmaRepository.delete(phirma);

        Assertions.assertEquals(8,phirmaRepository.getAll().size());


    }

    @Test
    void getById() {

        Phirma phirma=phirmaRepository.getById(5L);

        Assertions.assertEquals("Pete",phirma.getPh_name());
        Assertions.assertEquals("ad",phirma.getIdad().getAdmin_login());

    }


    @Test
    void getAll() {

        Phirma phirma=new Phirma();

        List<Phirma> phirmas = phirmaRepository.getAll();
        Assertions.assertEquals(6, phirmaRepository.getAll().size());
       Phirma newPhirma = phirmas.get(0);


    }

    @Test
    void getPhirma() {

       Phirma phirma =phirmaRepository.getPhirma("Pozhar");
        Assertions.assertEquals("Pozhar",phirma.getPh_name());

        Assertions.assertEquals("ad",phirma.getIdad().getAdmin_login());

    }


}