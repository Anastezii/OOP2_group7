package bg.tu_varna.sit.carrent.data.repositories;
import bg.tu_varna.sit.carrent.data.access.Connection;
import bg.tu_varna.sit.carrent.data.entities.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SmokerRepository implements DAORepositories<Smoker>{

    private static final Logger log=Logger.getLogger(SmokerRepository.class);

    public static SmokerRepository getInstance(){return SmokerRepository.SmokerRepositoryHolder.INSTANCE;}

    private static class SmokerRepositoryHolder {
        public static SmokerRepository INSTANCE=new SmokerRepository();
    }

    @Override
    public void save(Smoker obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.save(obj);
            log.info("Smoker was saved succesfully.");
        }catch (Exception ex){
            log.error("Smoker was saved error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void update(Smoker obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.update(obj);
            log.info("Smoker was update succesfully.");
        }catch (Exception ex){
            log.error("Smoker was update error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void delete(Smoker obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Smoker was delete succesfully.");
        }catch (Exception ex){
            log.error("Smoker was delete error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public List<Smoker> getByIg(Long id) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Smoker> smokers=new LinkedList<Smoker>() ;
        try{
            String jpql="SELECT s FROM Smoker s WHERE smoker_id ="+id;
            smokers.addAll(session.createQuery(jpql,Smoker.class).getResultList());
            log.info("Succesfully gets all smokers cars");

        }catch (Exception ex){
            log.error("Get ig smokers cars error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
        return smokers;
    }

    @Override
    public List<Smoker> getAll() {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Smoker> smokers=new LinkedList<Smoker>() ;
        try{
            String jpql="SELECT s FROM Smoker s";
            smokers.addAll(session.createQuery(jpql,Smoker.class).getResultList());
            log.info("Result all smokers cars");

        }catch (Exception ex){
            log.error("Get smokers cars error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
        return smokers;
    }

    public Smoker getSmoker(String SmokerType) {

        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Smoker> smokers =new ArrayList<>() ;

        try{
            String jpql="SELECT a FROM Smoker a WHERE a.smoker_type= :SmokerType";

            smokers.addAll(session.createQuery(jpql, Smoker.class).
                    setParameter("SmokerType",SmokerType).getResultList());
            log.info("Succesfully get all smokers");

        }catch (Exception ex){
            log.error("Get  smokers error : "+ex.getCause());
        }finally {
            transaction.commit();
            session.close();
        }
        return smokers.get(0);
        //return admins;
    }



}
