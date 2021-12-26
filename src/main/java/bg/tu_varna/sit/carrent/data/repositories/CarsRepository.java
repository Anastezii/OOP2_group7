package bg.tu_varna.sit.carrent.data.repositories;
import bg.tu_varna.sit.carrent.data.access.Connection;
import bg.tu_varna.sit.carrent.data.entities.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
public class CarsRepository implements DAORepositories<Cars>{

    private static final Logger log=Logger.getLogger(CarsRepository.class);

    public static CarsRepository getInstance(){return CarsRepository.CarsRepositoryHolder.INSTANCE;}

    private static class CarsRepositoryHolder {
        public static CarsRepository INSTANCE=new CarsRepository();
    }

    @Override
    public void save(Cars obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.save(obj);
            log.info("Car was saved succesfully.");
        }catch (Exception ex){
            log.error("Car was saved error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void update(Cars obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.update(obj);
            log.info("Car was update succesfully.");
        }catch (Exception ex){
            log.error("Car was update error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(Cars obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Car was delete succesfully.");
        }catch (Exception ex){
            log.error("Car was delete error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public List<Cars> getByIg(Long id) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Cars> cars=new LinkedList<Cars>() ;
        try{
            String jpql="SELECT c FROM Cars c WHERE idCARS ="+id;
            cars.addAll(session.createQuery(jpql,Cars.class).getResultList());
            log.info("Succesfully gets all cars");

        }catch (Exception ex){
            log.error("Get ig cars error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        return cars;
    }

    @Override
    public List<Cars> getAll() {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Cars> cars=new LinkedList<Cars>() ;
        try{
            String jpql="SELECT c FROM Cars c";
            cars.addAll(session.createQuery(jpql,Cars.class).getResultList());
            log.info("Result all cars");

        }catch (Exception ex){
            log.error("Get cars error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        return cars;
    }
}
