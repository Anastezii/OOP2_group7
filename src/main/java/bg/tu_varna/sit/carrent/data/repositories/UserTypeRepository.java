package bg.tu_varna.sit.carrent.data.repositories;
import bg.tu_varna.sit.carrent.data.access.Connection;
import bg.tu_varna.sit.carrent.data.entities.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class UserTypeRepository implements DAORepositories<UserType>{
    private static final Logger log=Logger.getLogger(UserTypeRepository.class);

    public static UserTypeRepository getInstance(){return UserTypeRepository.UserTypeRepositoryHolder.INSTANCE;}

    private static class UserTypeRepositoryHolder {
        public static UserTypeRepository INSTANCE=new UserTypeRepository();
    }
    @Override
    public void save(UserType obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.save(obj);
            log.info("UserType was saved succesfully.");
        }catch (Exception ex){
            log.error("UserType was saved error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void update(UserType obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.update(obj);
            log.info("UserType was update succesfully.");
        }catch (Exception ex){
            log.error("UserType was update error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void delete(UserType obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.delete(obj);
            log.info("UserType was delete succesfully.");
        }catch (Exception ex){
            log.error("UserType was delete error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public List<UserType> getByIg(Long id) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<UserType> types=new LinkedList<UserType>() ;
        try{
            String jpql="SELECT ut FROM UserType ut WHERE userType_id ="+id;
            types.addAll(session.createQuery(jpql,UserType.class).getResultList());
            log.info("Sucesfully gets all types");

        }catch (Exception ex){
            log.error("Get ig types error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
        return types;
    }

    @Override
    public List<UserType> getAll() {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<UserType> types=new LinkedList<UserType>() ;
        try{
            String jpql="SELECT ut FROM UserType ut";
           types.addAll(session.createQuery(jpql,UserType.class).getResultList());
            log.info("Result all types");

        }catch (Exception ex){
            log.error("Get types error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
        return types;
    }
}
