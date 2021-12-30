package bg.tu_varna.sit.carrent.data.repositories;

import bg.tu_varna.sit.carrent.data.access.Connection;
import bg.tu_varna.sit.carrent.data.entities.Admin;
import bg.tu_varna.sit.carrent.data.entities.Client;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class AdminRepository implements DAORepositories<Admin>{

    private static final Logger log=Logger.getLogger(AdminRepository.class);

    public static AdminRepository getInstance(){return AdminRepository.AdminRepositoryHolder.INSTANCE;}

    private static class AdminRepositoryHolder {
        public static AdminRepository INSTANCE=new AdminRepository();
    }

    @Override
    public void save(Admin obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.save(obj);
            log.info("Admin was saved succesfully.");
        }catch (Exception ex){
            log.error("Admin was saved error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void update(Admin obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.update(obj);
            log.info("Admin was updated succesfully.");
        }catch (Exception ex){
            log.error("Admin was updated error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
    }

    @Override
    public void delete(Admin obj) {
       /* Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Admin was deleted succesfully.");
        }catch (Exception ex){
            log.error("Admin was deleted, error :("+ex.getCause());
        }finally {
            transaction.commit();
        }*/
    }

    @Override
    public List<Admin> getByIg(Long id) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
      List<Admin> admins =new LinkedList<Admin>() ;
        try{
            String jpql="SELECT t FROM Admin t WHERE admin_id ="+id;
            admins.addAll(session.createQuery(jpql, Admin.class).getResultList());
            log.info("Succesfully get all admins");

        }catch (Exception ex){
            log.error("Get ig admins error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }session.close();
        return admins;
    }

    @Override
    public List<Admin> getAll() {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Admin> admins =new LinkedList<Admin>() ;
        try{
            String jpql="SELECT t FROM Admin t";
            admins.addAll(session.createQuery(jpql, Admin.class).getResultList());
            log.info("Result all admins");

        }catch (Exception ex){
            log.error("Get admins error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        return admins;
    }

    public List<Admin> getLogin(String login,String pass){
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Admin> admins =new LinkedList<Admin>() ;
        try{
            String jpql="SELECT t FROM Admin t WHERE t.admin_login= :login AND t.admin_password= :pass ";
            admins.addAll(session.createQuery(jpql, Admin.class).setParameter("login",login).
                    setParameter("pass",pass).getResultList());
            log.info("Result all admins which matched.");

        }catch (Exception ex){
            log.error("Get admins error : "+ex.getCause());
        }finally {
            transaction.commit();
        }
        return admins;
    }
}
