package bg.tu_varna.sit.carrent.data.repositories;

import bg.tu_varna.sit.carrent.data.entities.Cars;
import bg.tu_varna.sit.carrent.data.entities.Client;
import bg.tu_varna.sit.carrent.data.entities.Operator;
import bg.tu_varna.sit.carrent.data.entities.Phirma;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarsRepositoryTest {

    private CarsRepository carsRepository;
    private  ModelRepository repositoryModel;
    private  SmokerRepository repositorySmoker;
    private  BrandRepository repositoryBrand;

    @BeforeEach
    void setUp() {
        carsRepository=new CarsRepository();
        repositoryModel=new ModelRepository();
        repositorySmoker=new SmokerRepository();
        repositoryBrand=new BrandRepository();

    }

    @Test
    void save() {

        Cars cars=new Cars();
      cars.setCars_year("2019");
      cars.setCars_color("Lemon");
      cars.setCars_class("S");
      cars.setBrand(repositoryBrand.getBrand("Mitsubishi"));
      cars.setIdMODEL(repositoryModel.getModel("Outlander"));
      cars.setIdSMOKER(repositorySmoker.getSmoker("n"));
      cars.setCars_reg_num("CT 2147 H");


        carsRepository.save(cars);

        Long id=cars.getCars_id();
        Assertions.assertNotNull(id);

        Assertions.assertEquals(6,carsRepository.getAll().size());
        Cars newCar=carsRepository.getById(id);

        Assertions.assertEquals("2019",newCar.getCars_year());
        Assertions.assertEquals("Lemon",newCar.getCars_color());
        Assertions.assertEquals("S",newCar.getCars_class());
        Assertions.assertEquals("Mitsubishi",newCar.getBrand().getBrand_name());
        Assertions.assertEquals("Outlander",newCar.getIdMODEL().getModel_name());
        Assertions.assertEquals("n",newCar.getIdSMOKER().getSmoker_Type());
        Assertions.assertEquals("CT 2147 H",newCar.getCars_reg_num());

    }

    @Test
    void update() {

        Cars cars=new Cars();
        cars.setCars_year("2020");
        cars.setCars_color("Blue Sky");
        cars.setCars_class("S");
        cars.setBrand(repositoryBrand.getBrand("Lamborgini"));
        cars.setIdMODEL(repositoryModel.getModel("Huracan"));
        cars.setIdSMOKER(repositorySmoker.getSmoker("n"));
        cars.setCars_reg_num("B 5263 CT");

        carsRepository.save(cars);
        cars.setCars_year("2021");
        cars.setCars_class("SE");
        carsRepository.update(cars);

        Long id=cars.getCars_id();
        Assertions.assertNotNull(id);

        Assertions.assertEquals(7,carsRepository.getAll().size());
        Cars newCar=carsRepository.getById(id);

        Assertions.assertEquals("2021",newCar.getCars_year());
        Assertions.assertEquals("Blue Sky",newCar.getCars_color());
        Assertions.assertEquals("SE",newCar.getCars_class());
        Assertions.assertEquals("Lamborgini",newCar.getBrand().getBrand_name());
        Assertions.assertEquals("Huracan",newCar.getIdMODEL().getModel_name());
        Assertions.assertEquals("n",newCar.getIdSMOKER().getSmoker_Type());
        Assertions.assertEquals("B 5263 CT",newCar.getCars_reg_num());

    }



    @Test
    void getCars() {

        Cars cars=carsRepository.getCars("B 7927 HE");
        Assertions.assertEquals("S",cars.getCars_class());
        Assertions.assertEquals("Black",cars.getCars_color());
        Assertions.assertEquals("2016",cars.getCars_year());
        Assertions.assertEquals("X5",cars.getIdMODEL().getModel_name());
        Assertions.assertEquals("n",cars.getIdSMOKER().getSmoker_Type());
        Assertions.assertEquals("BMW",cars.getBrand().getBrand_name());

    }
}