package bg.tu_varna.sit.carrent.business.services;

import bg.tu_varna.sit.carrent.data.entities.Brand;
import bg.tu_varna.sit.carrent.data.entities.Cars;
import bg.tu_varna.sit.carrent.data.entities.Model;
import bg.tu_varna.sit.carrent.data.entities.Phirma;
import bg.tu_varna.sit.carrent.data.repositories.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private final CarsRepository repository= CarsRepository.getInstance();
    private final ModelRepository repositoryModel= ModelRepository.getInstance();
    private final SmokerRepository repositorySmoker= SmokerRepository.getInstance();
    private final BrandRepository repositoryBrand= BrandRepository.getInstance();




    public static CarService getInstance(){
        return  CarService.CarServiceHolder.INSTANCE;
    }

    private static class CarServiceHolder {

        public static final CarService INSTANCE = new CarService();
    }


    public ObservableList<Cars> getAllTask( ){
        List<Cars> cars=repository.getAll();
        return FXCollections.observableList(cars.stream().map(c->new Cars(c.getCars_id(),c.getCars_class(),
                        c.getCars_color(),c.getCars_reg_num(),c.getCars_year(),c.getIdMODEL(),c.getIdSMOKER(),
                        c.getBrand())).
                collect(Collectors.toList()));

    }

    public void SaveCar(String model,String color,String Year,String classCar,String smoker,String regNum,String brand){

        Cars cars=new Cars();
        cars.setCars_class(classCar);
        cars.setCars_color(color);
        cars.setCars_year(Year);
        cars.setCars_reg_num(regNum);
        Brand brandName=repositoryBrand.getBrand(brand);
        if(brandName==null){
            Brand brandNew=new Brand();
            brandNew.setBrand_name(brand);
            try{
                repositoryBrand.save(brandNew);}
            catch(Exception ex ){
                ex.getCause();
            }
            cars.setBrand(repositoryBrand.getBrand(brand));
        }else{
            cars.setBrand(repositoryBrand.getBrand(brand));
        }
       Model modelName= repositoryModel.getModel(model);
       if(modelName==null){
            Model modelNew=new Model();
          modelNew.setModel_name(model);
            try{
                repositoryModel.save(modelNew);}
            catch(Exception ex ){
                ex.getCause();
            }

            cars.setIdMODEL(repositoryModel.getModel(model));
        }else{
            cars.setIdMODEL(repositoryModel.getModel(model));
        }
        cars.setIdSMOKER(repositorySmoker.getSmoker(smoker));


        try{
            repository.save(cars);}
        catch(Exception ex ){
            ex.getCause();
        }

    }


}