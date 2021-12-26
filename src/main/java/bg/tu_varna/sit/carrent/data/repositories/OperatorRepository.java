package bg.tu_varna.sit.carrent.data.repositories;

import bg.tu_varna.sit.carrent.data.access.Connection;
import bg.tu_varna.sit.carrent.data.entities.Client;
import bg.tu_varna.sit.carrent.data.entities.Operator;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OperatorRepository implements DAORepositories<Operator> {

    private static final Logger log=Logger.getLogger(OperatorRepository.class);

    public static OperatorRepository getInstance(){return OperatorRepository.OperatorRepositoryHolder.INSTANCE;}

    private static class OperatorRepositoryHolder {
        public static OperatorRepository INSTANCE=new OperatorRepository();
    }

    @Override
    public void save(Operator obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.save(obj);
            log.info("Operator was saved succesfully.");
        }catch (Exception ex){
            log.error("Operator wasn`t saved , error :("+ ex.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void update(Operator obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.update(obj);
            log.info("Operator was saved succesfully.");
        }catch (Exception ex){
            log.error("Operator wasn`t saved , error :("+ ex.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(Operator obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Operator was saved succesfully.");
        }catch (Exception ex){
            log.error("Operator wasn`t saved , error :("+ ex.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public List<Operator> getByIg(Long id) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Operator> operators=new LinkedList<Operator>() ;
        try{
            String jpql="SELECT o FROM Operator o WHERE idOPERATOR ="+id;
            operators.addAll(session.createQuery(jpql,Operator.class).getResultList());
            log.info("Succesfully gets all operators");

        }catch (Exception ex){
            log.error("Get ig operator error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        return operators;
    }

    @Override
    public List<Operator> getAll() {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Operator> operators=new LinkedList<Operator>() ;
        try{
            String jpql="SELECT o FROM Operator o";
            operators.addAll(session.createQuery(jpql,Operator.class).getResultList());
            log.info("Result all operators");

        }catch (Exception ex){
            log.error("Get operator error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        return operators;
    }

}