package bg.tu_varna.sit.carrent.data.repositories;
import bg.tu_varna.sit.carrent.data.access.Connection;
import bg.tu_varna.sit.carrent.data.entities.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
public class ModelRepository implements DAORepositories<Model>{

    private static final Logger log=Logger.getLogger(ModelRepository.class);

    public static ModelRepository getInstance(){return ModelRepository.ModelRepositoryHolder.INSTANCE;}

    private static class ModelRepositoryHolder {
        public static ModelRepository INSTANCE=new ModelRepository();
    }

    @Override
    public void save(Model obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.save(obj);
            log.info("Model was saved succesfully.");
        }catch (Exception ex){
            log.error("Model was saved error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void update(Model obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.update(obj);
            log.info("Model was update succesfully.");
        }catch (Exception ex){
            log.error("Model was update error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(Model obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Model was delete succesfully.");
        }catch (Exception ex){
            log.error("Model was delete error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public List<Model> getByIg(Long id) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Model> models=new LinkedList<Model>() ;
        try{
            String jpql="SELECT m FROM Model m WHERE idMODEL ="+id;
            models.addAll(session.createQuery(jpql,Model.class).getResultList());
            log.info("Succesfully gets all models");

        }catch (Exception ex){
            log.error("Get ig models error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        return models;
    }

    @Override
    public List<Model> getAll() {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Model> models=new LinkedList<Model>() ;
        try{
            String jpql="SELECT m FROM Model m";
            models.addAll(session.createQuery(jpql,Model.class).getResultList());
            log.info("Result all models");

        }catch (Exception ex){
            log.error("Get models error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        return models;
    }
}
