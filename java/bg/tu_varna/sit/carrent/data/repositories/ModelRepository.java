package bg.tu_varna.sit.carrent.data.repositories;
import bg.tu_varna.sit.carrent.data.access.Connection;
import bg.tu_varna.sit.carrent.data.entities.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
        session.close();
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
        session.close();
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
        session.close();
    }

    @Override
    public Model getById(Long id) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Model> models=new LinkedList<Model>() ;
        try{
            String jpql="SELECT m FROM Model m WHERE model_id ="+id;
            models.addAll(session.createQuery(jpql,Model.class).getResultList());
            log.info("Succesfully gets all models");

        }catch (Exception ex){
            log.error("Get ig models error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
        return models.get(0);
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
        session.close();
        return models;
    }

    public Model getModel(String ModelName) {

        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Model> models =new ArrayList<>() ;

        try{
            String jpql="SELECT a FROM Model a WHERE a.model_name= :ModelName";

            models.addAll(session.createQuery(jpql, Model.class).
                    setParameter("ModelName",ModelName).getResultList());
            log.info("Succesfully get all models");

        }catch (Exception ex){
            log.error("Get  models error : "+ex.getCause());
        }finally {
            transaction.commit();
            session.close();
        }
        if(models.size()!=0){
        return models.get(0);}
        else{
            return null;
        }
        //return admins;
    }

}
