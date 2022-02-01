package bg.tu_varna.sit.carrent.business.services;

import bg.tu_varna.sit.carrent.data.entities.Admin;
import bg.tu_varna.sit.carrent.data.entities.Phirma;
import bg.tu_varna.sit.carrent.data.repositories.AdminRepository;
import bg.tu_varna.sit.carrent.data.repositories.PhirmaRepository;
import bg.tu_varna.sit.carrent.data.repositories.UserRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class PhirmaService {

    private final PhirmaRepository repository= PhirmaRepository.getInstance();
    private final AdminRepository repository1= AdminRepository.getInstance();
    private final UserRepository repositoryUser= UserRepository.getInstance();


    public static PhirmaService getInstance(){
        return  PhirmaService.PhirmaServiceHolder.INSTANCE;
    }

    private static class PhirmaServiceHolder {

        public static final PhirmaService INSTANCE = new PhirmaService();
    }

    public ObservableList<Phirma> getAllTask( ){
        List<Phirma> phirmas=repository.getAll();
        return FXCollections.observableList(phirmas.stream().map(o->new Phirma(o.getPh_id(),
                        o.getPh_name(),o.getIdad())).
                collect(Collectors.toList()));

    }

    public void SavePhirma(String phirmaName,String adminName){

        Phirma phirma=new Phirma();
        phirma.setPh_name(phirmaName);
        phirma.setIdad(repository1.getAdmin(adminName));
        //phirma.setIdad(new Admin(String.valueOf(admin.get(0).getAdmin_id())));
       /* if(admin.get(0).equals("adm")){
        phirma.setIdad(new Admin(2L));}
        else{
            phirma.setIdad(new Admin(1L));}*/

        //phirma.setIdad(new Admin(3L));
        //phirma.setPh_id(4L);
       try{
           repository.save(phirma);}
       catch(Exception ex ){
           ex.getCause();
       }

    }



}
