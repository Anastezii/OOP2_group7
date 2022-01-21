package bg.tu_varna.sit.carrent.business.services;

import bg.tu_varna.sit.carrent.data.entities.Cars;
import bg.tu_varna.sit.carrent.data.entities.Phirma;
import bg.tu_varna.sit.carrent.data.repositories.CarsRepository;
import bg.tu_varna.sit.carrent.data.repositories.PhirmaRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private final CarsRepository repository= CarsRepository.getInstance();


    public static CarService getInstance(){
        return  CarService.CarServiceHolder.INSTANCE;
    }

    private static class CarServiceHolder {

        public static final CarService INSTANCE = new CarService();
    }


    public ObservableList<Cars> getAllTask( ){
        List<Cars> cars=repository.getAll();
        return FXCollections.observableList(cars.stream().map(c->new Cars(c.getCars_id(),c.getCars_class(),
                        c.getCars_color(),c.getCars_reg_num(),c.getCars_year(),c.getIdMODEL(),c.getIdSMOKER())).
                collect(Collectors.toList()));

    }


}
