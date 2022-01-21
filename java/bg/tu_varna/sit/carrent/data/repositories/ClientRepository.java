package bg.tu_varna.sit.carrent.data.repositories;
import bg.tu_varna.sit.carrent.data.access.Connection;
import bg.tu_varna.sit.carrent.data.entities.Client;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class ClientRepository implements DAORepositories<Client> {
    private static final Logger log=Logger.getLogger(ClientRepository.class);

    public static ClientRepository getInstance(){return ClientRepository.ClientRepositoryHolder.INSTANCE;}

    private static class ClientRepositoryHolder {
        public static ClientRepository INSTANCE=new ClientRepository();
    }



    @Override
    public void save(Client obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.save(obj);
            log.info("Client was saved succesfully.");
        }catch (Exception ex){
            log.error("Client was saved error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void update(Client obj) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.update(obj);
            log.info("Client was updated succesfully.");
        }catch (Exception ex){
            log.error("Client was updated error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public void delete(Client obj) {
       Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.delete(obj);
            log.info("Client was deleted succesfully.");
        }catch (Exception ex){
            log.error("Client was deleted error :("+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
    }

    @Override
    public List<Client> getByIg(Long id) {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Client> clients=new LinkedList<Client>() ;
        try{
            String jpql="SELECT cl FROM Client cl WHERE cl_id ="+id;
            clients.addAll(session.createQuery(jpql,Client.class).getResultList());
            log.info("Succesfully gets all clients");

        }catch (Exception ex){
            log.error("Get ig client error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
        return clients;
    }

    @Override
    public List<Client> getAll() {
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Client> clients=new LinkedList<Client>() ;
        try{
            String jpql="SELECT cl FROM Client cl";
           clients.addAll(session.createQuery(jpql,Client.class).getResultList());
            log.info("Result all clients");

        }catch (Exception ex){
            log.error("Get client error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }
        session.close();
        return clients;
    }


    public List<Client> getLogin(String login,String pass){
        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<Client> clients =new LinkedList<Client>() ;
        try{
            String jpql="SELECT t FROM Client t WHERE t.cl_login= :login AND t.cl_password= :pass ";
            clients.addAll(session.createQuery(jpql, Client.class).setParameter("login",login).
                    setParameter("pass",pass).getResultList());
            log.info("Result all admins which matched.");

        }catch (Exception ex){
            log.error("Get admins error : "+ex.getCause());
        }finally {
            transaction.commit();
        }
        session.close();
        return clients;
    }
}
