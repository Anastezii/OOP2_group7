package bg.tu_varna.sit.carrent.business.services;

import bg.tu_varna.sit.carrent.data.entities.Phirma;
import bg.tu_varna.sit.carrent.data.entities.Rent;
import bg.tu_varna.sit.carrent.data.repositories.PhirmaRepository;
import bg.tu_varna.sit.carrent.data.repositories.RentRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class RentService {

    private final RentRepository repository= RentRepository.getInstance();


    public static RentService getInstance(){
        return RentService.RentServiceHolder.INSTANCE;
    }

    private static class RentServiceHolder {

        public static final RentService INSTANCE = new RentService();
    }

    public ObservableList<Rent> getAllTask( ){
        List<Rent> rents=repository.getAll();
        return FXCollections.observableList(rents.stream().map(o->new Rent(o.getRent_id(),o.getRent_date(),o.getRent_date_end(),
                        o.getIdCARS(),o.getIdoper(),o.getIdcl(),o.getIdph(),o.getKm())).
                collect(Collectors.toList()));

    }




}
