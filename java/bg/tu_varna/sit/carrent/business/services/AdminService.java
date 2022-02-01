package bg.tu_varna.sit.carrent.business.services;

import bg.tu_varna.sit.carrent.data.access.Connection;
import bg.tu_varna.sit.carrent.data.entities.Admin;
import bg.tu_varna.sit.carrent.data.repositories.AdminRepository;
import bg.tu_varna.sit.carrent.presentation.models.AdminListViewMOdel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AdminService {


    private final AdminRepository repository= AdminRepository.getInstance();


    public static AdminService getInstance(){
        return  AdminService.AdminServiceHolder.INSTANCE;
    }



    private static class AdminServiceHolder {

        public static final AdminService INSTANCE = new AdminService();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdminService)) return false;
        AdminService that = (AdminService) o;
        return repository.equals(that.repository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repository);
    }


    public ObservableList<Admin> getAllTask(String login,String pass){
        List<Admin> admins=repository.getLogin(login,pass);
        return FXCollections.observableList(admins.stream().map(o->new Admin(o.getAdmin_login(),
                o.getAdmin_password())).collect(Collectors.toList()));

    }
   /* public ObservableList<Admin> getAdmin(String AdminName){
        List<Admin> admins=repository.getAdmin(AdminName);
        return FXCollections.observableList(admins.stream().map(o->new Admin(o.getAdmin_id())).collect(Collectors.toList()));

    }*/

     /*public ResultSet getAdmin(Admin admin){
        ResultSet resSet=null;

        Session session= Connection.openSession();
        Transaction transaction=session.beginTransaction();
        List<String> admins =repository.getLogin() ;
        // String jpql="SELECT t FROM Admin t WHERE t.admin_login= :login AND t.admin_password= :pass ";

        /*try {
           // String jpql="SELECT * FROM Admin  WHERE ADMIN_LOGIN = ? AND ADMIN_PASSWORD=?";
          //  Query spSQLQuery= (Query) session.createSQLQuery("SELECT * FROM Admin  WHERE ADMIN_LOGIN = ? AND ADMIN_PASSWORD=?");
           //spSQLQuery.setParameter(1,)
            admins.setParametr;
            log.info("Result all admins which matched.");
            // admins.set(1,admin.getAdmin_login());
          //  admins.set(2,admin.getAdmin_password());
        }catch (Exception ex){
            log.error("Get  admins error : "+ex.getMessage());
        }finally {
            transaction.commit();
        }session.close();
        return resSet;*/
}

