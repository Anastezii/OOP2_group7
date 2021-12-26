package bg.tu_varna.sit.carrent.data.repositories;
import bg.tu_varna.sit.carrent.data.access.Connection;
import bg.tu_varna.sit.carrent.data.entities.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
public class PhirmaRepository implements DAORepositories<Phirma>{

    private static final Logger log=Logger.getLogger(PhirmaRepository.class);

    public static PhirmaRepository getInstance(){return PhirmaRepository.PhirmaRepositoryHolder.INSTANCE;}

    private static class PhirmaRepositoryHolder {
        public static PhirmaRepository INSTANCE=new PhirmaRepository();
    }

    @Override
    public void save(Phirma obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.save(obj);
            log.info("Phirma was saved succesfully.");
        }catch (Exception ex){
            log.error("Phirma was saved error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void update(Phirma obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.update(obj);
            log.info("Phirma was update succesfully.");
        }catch (Exception ex){
            log.error("Phirma was update error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(Phirma obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Phirma was delete succesfully.");
        }catch (Exception ex){
            log.error("Phirma was delete error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public List<Phirma> getByIg(Long id) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Phirma> phirmas=new LinkedList<Phirma>() ;
        try{
            String jpql="SELECT p FROM Phirma p WHERE idPhirma ="+id;
            phirmas.addAll(session.createQuery(jpql,Phirma.class).getResultList());
            log.info("Succesfully gets  all phirmas");

        }catch (Exception ex){
            log.error("Get ig phirmas error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        return phirmas;
    }

    @Override
    public List<Phirma> getAll() {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Phirma> phirmas=new LinkedList<Phirma>() ;
        try{
            String jpql="SELECT p FROM Phirma p";
            phirmas.addAll(session.createQuery(jpql,Phirma.class).getResultList());
            log.info("Result all phirmas");

        }catch (Exception ex){
            log.error("Get phirmas error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        return phirmas;
    }
}
