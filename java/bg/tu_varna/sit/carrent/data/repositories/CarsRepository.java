package bg.tu_varna.sit.carrent.data.repositories;
import bg.tu_varna.sit.carrent.data.access.Connection;
import bg.tu_varna.sit.carrent.data.entities.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        session.close();
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
        session.close();
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
        session.close();
    }

    @Override
    public Cars getById(Long id) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Cars> cars=new LinkedList<Cars>() ;
        try{
            String jpql="SELECT c FROM Cars c WHERE cars_id ="+id;
            cars.addAll(session.createQuery(jpql,Cars.class).getResultList());
            log.info("Succesfully gets all cars");

        }catch (Exception ex){
            log.error("Get ig cars error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
        return cars.get(0);
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
        session.close();
        return cars;
    }

    public Cars getCars(String CarRegNum) {

        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Cars> cars =new ArrayList<>() ;

        try{
            String jpql="SELECT a FROM Cars a WHERE a.cars_reg_num= :CarRegNum";

            cars.addAll(session.createQuery(jpql,Cars.class).
                    setParameter("CarRegNum",CarRegNum).getResultList());
            log.info("Succesfully get all cars");

        }catch (Exception ex){
            log.error("Get  cars error : "+ex.getCause());
        }finally {
            transaction.commit();
            session.close();
        }
        if(cars.size()!=0){
        return cars.get(0);}
        else{
            return null;
        }

    }
}
