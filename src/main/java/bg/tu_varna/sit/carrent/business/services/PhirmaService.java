package bg.tu_varna.sit.carrent.business.services;

import bg.tu_varna.sit.carrent.data.entities.Phirma;
import bg.tu_varna.sit.carrent.data.repositories.PhirmaRepository;

public class PhirmaService {

    private final PhirmaRepository repository= PhirmaRepository.getInstance();


    public static PhirmaService getInstance(){
        return  PhirmaService.PhirmaServiceHolder.INSTANCE;
    }

    private static class PhirmaServiceHolder {

        public static final PhirmaService INSTANCE = new PhirmaService();
    }

    public void SavePhirma(String phName){
        Phirma phirma=new Phirma();
        phirma.setPh_name(phName);
        repository.save(phirma);

    }

}
