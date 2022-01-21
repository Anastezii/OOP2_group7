package bg.tu_varna.sit.carrent.data.repositories;
import bg.tu_varna.sit.carrent.data.access.Connection;
import bg.tu_varna.sit.carrent.data.entities.*;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class BrandRepository implements DAORepositories<Brand>{

    private static final Logger log=Logger.getLogger(BrandRepository.class);

    public static BrandRepository getInstance(){return BrandRepository.BrandRepositoryHolder.INSTANCE;}

    private static class BrandRepositoryHolder {
        public static BrandRepository INSTANCE=new BrandRepository();
    }

    @Override
    public void save(Brand obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.save(obj);
            log.info("Brand was saved succesfully.");
        }catch (Exception ex){
            log.error("Brand was saved error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void update(Brand obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.update(obj);
            log.info("Brand was update succesfully.");
        }catch (Exception ex){
            log.error("Brand was update error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void delete(Brand obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Brand was delete succesfully.");
        }catch (Exception ex){
            log.error("Brand was delete error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public List<Brand> getByIg(Long id) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Brand> brands=new LinkedList<Brand>() ;
        try{
            String jpql="SELECT b FROM Brand b WHERE brand_id ="+id;
            brands.addAll(session.createQuery(jpql,Brand.class).getResultList());
            log.info("Succesfully gets all brands");

        }catch (Exception ex){
            log.error("Get ig brands error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
        return brands;
    }

    @Override
    public List<Brand> getAll() {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Brand> brands=new LinkedList<Brand>() ;
        try{
            String jpql="SELECT b FROM Brand b";
            brands.addAll(session.createQuery(jpql,Brand.class).getResultList());
            log.info("Result all brands");

        }catch (Exception ex){
            log.error("Get brands error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
        return brands;
    }
}
