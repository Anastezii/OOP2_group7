package bg.tu_varna.sit.carrent.business.services;

import bg.tu_varna.sit.carrent.data.repositories.CarsRepository;
import bg.tu_varna.sit.carrent.data.repositories.PhirmaRepository;

public class CarService {
    private final CarsRepository repository= CarsRepository.getInstance();


    public static CarService getInstance(){
        return  CarService.CarServiceHolder.INSTANCE;
    }

    private static class CarServiceHolder {

        public static final CarService INSTANCE = new CarService();
    }


}
