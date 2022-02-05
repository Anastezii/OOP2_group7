package bg.tu_varna.sit.carrent.data.repositories;
import bg.tu_varna.sit.carrent.data.access.Connection;
import bg.tu_varna.sit.carrent.data.entities.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class RentRepository implements DAORepositories<Rent>{

    private static final Logger log=Logger.getLogger(RentRepository.class);

    public static RentRepository getInstance(){return RentRepository.RentRepositoryHolder.INSTANCE;}

    private static class RentRepositoryHolder {
        public static RentRepository INSTANCE=new RentRepository();
    }

    @Override
    public void save(Rent obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.save(obj);
            log.info("Rent data was saved succesfully.");
        }catch (Exception ex){
            log.error("Rent data saved error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void update(Rent obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.update(obj);
            log.info("Rent data was update succesfully.");
        }catch (Exception ex){
            log.error("Rent data update error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void delete(Rent obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Rent data was delete succesfully.");
        }catch (Exception ex){
            log.error("Rent data delete error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public Rent getById(Long id) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Rent> rents=new LinkedList<Rent>() ;
        try{
            String jpql="SELECT r FROM Rent r WHERE rent_id ="+id;
            rents.addAll(session.createQuery(jpql,Rent.class).getResultList());
            log.info("Succesfully gets all rents data");

        }catch (Exception ex){
            log.error("Get ig rents data error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
        return rents.get(0);
    }

    @Override
    public List<Rent> getAll() {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Rent> rents=new LinkedList<Rent>() ;
        try{
            String jpql="SELECT r FROM Rent r";
            rents.addAll(session.createQuery(jpql,Rent.class).getResultList());
            log.info("Result all rents data");

        }catch (Exception ex){
            log.error("Get rents data error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
        return rents;
    }


    public Rent CheckRent(LocalDate dateStartRent,LocalDate dateEndRent) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Rent> rents=new LinkedList<Rent>() ;
        try{
            String jpql="SELECT r FROM Rent r WHERE r.rent_date=: dateStartRent AND r.rent_date_end=:dateEndRent";
            rents.addAll(session.createQuery(jpql,Rent.class).setParameter("dateStartRent",dateStartRent).
                    setParameter("dateEndRent",dateEndRent).getResultList());
            log.info("Result all rents data");

        }catch (Exception ex){
            log.error("Get rents data error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
        if(rents.size()!=0){
            return rents.get(0);
        }else{
            return null;
        }

    }


}
