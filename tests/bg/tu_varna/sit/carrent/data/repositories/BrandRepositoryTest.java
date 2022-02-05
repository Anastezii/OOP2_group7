package bg.tu_varna.sit.carrent.data.repositories;

import bg.tu_varna.sit.carrent.data.entities.Brand;
import bg.tu_varna.sit.carrent.data.entities.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandRepositoryTest {

    private  BrandRepository repositoryBrand;

    @BeforeEach
    void setUp() {
        repositoryBrand=new BrandRepository();
    }

    @Test
    void save() {

        Brand brand=new Brand();

        brand.setBrand_name("Mazerati");

        repositoryBrand.save(brand);

        Long id=brand.getBrand_id();
        Assertions.assertNotNull(id);

        Assertions.assertEquals(10,repositoryBrand.getAll().size());
       Brand newBrand=repositoryBrand.getById(id);

        Assertions.assertEquals("Mazerati",newBrand.getBrand_name());

    }

    @Test
    void getBrand() {

       Brand brand=repositoryBrand.getBrand("Lamborgini");
        Assertions.assertEquals("Lamborgini",brand.getBrand_name());

    }
}