package bg.tu_varna.sit.carrent.business.services;

import bg.tu_varna.sit.carrent.data.entities.Admin;
import bg.tu_varna.sit.carrent.data.entities.Phirma;
import bg.tu_varna.sit.carrent.data.repositories.PhirmaRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class PhirmaService {

    private final PhirmaRepository repository= PhirmaRepository.getInstance();


    public static PhirmaService getInstance(){
        return  PhirmaService.PhirmaServiceHolder.INSTANCE;
    }

    private static class PhirmaServiceHolder {

        public static final PhirmaService INSTANCE = new PhirmaService();
    }

    public ObservableList<Phirma> getAllTask( String admins){
        List<Phirma> adminLog=repository.getAdminLogin(admins);
        return FXCollections.observableList(adminLog.stream().map(o->new Phirma(o.getIdad())).
                collect(Collectors.toList()));

    }

    public void SavePhirma(String phName){
        Phirma phirma=new Phirma();
        phirma.setPh_name(phName);
        phirma.setIdad(phirma.getIdad());
        repository.save(phirma);

    }

}
