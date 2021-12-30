package bg.tu_varna.sit.carrent.presentation.controlers;
import bg.tu_varna.sit.carrent.business.services.AdminService;
import bg.tu_varna.sit.carrent.data.access.Connection;
import bg.tu_varna.sit.carrent.data.entities.Admin;
import bg.tu_varna.sit.carrent.data.repositories.AdminRepository;
import bg.tu_varna.sit.carrent.presentation.models.AdminListViewMOdel;
import com.mysql.cj.log.Log;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminLogin  {

    private final AdminService service = AdminService.getInstance();

    @FXML
    private TextField textLogin;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button buttonAdmin;

    @FXML
    public void initialize() {
        buttonAdmin.setOnMouseClicked(this::handle);
    }

    public void handle(Event event) {
        String loginAdmin = textLogin.getText().trim();
        String passAdmin = passwordField.getText().trim();
        Admin admin = new Admin(loginAdmin,passAdmin);
     //  admin.setAdmin_login(loginAdmin);
       // admin.setAdmin_password(passAdmin);
        ObservableList<Admin> allTask = service.getAllTask(loginAdmin,passAdmin);

        boolean Login=false;

        for (Admin adminsLog:allTask) {
            if(admin.getAdmin_login().equals(loginAdmin) && admin.getAdmin_password().equals(passAdmin)){
                Login=true;
                System.out.println("True");
                extracted();
            }
            else{
                System.out.println("error in adm");
                Login=false;
            }
        }


      /*  if(textLogin instanceof ObservableList<?>){
            for (Object o:(ObservableList<?>)textLogin) {
                if(o instanceof Admin){
                    if(passwordField instanceof ObservableList<?>){
                        for (Object obj: (ObservableList<?>)passwordField){
                            if (obj instanceof Admin){
                                allTask.add((Admin)o);
                                allTask.add((Admin) obj);
                                Login=true;
                                buttonAdmin.setOnAction(this::extracted);
                            }
                        }
                    }
                }
            }
        }else{
            System.out.println("Don`t exist this admin login or pass");
            Login=false;
        }*/

       /* if (!loginAdmin.equals("") && !passAdmin.equals("")) {
            //  boolean adminLog=service.equals(textLogin)

        } else {
            System.out.println("Not correct login and pass");
        }*/

    }

    private void extracted() {
        Parent root;
        try{
            URL pathAdminWindow = getClass().getResource("/bg/tu_varna/sit/carrent/presentation.view/AdminWindow.fxml");
            root= FXMLLoader.load(pathAdminWindow);
            Stage stage=new Stage();
            stage.setTitle("Admin Window");
            stage.setScene(new Scene(root));
            stage.show();
            //((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        }catch(IOException e){
            e.getCause();
        }
    }
}


   /* Connection connection = null;
    PreparedStatement preparedStatement = null;*/
   // ResultSet resultSet = null;

    /*private void loginAdmins(String loginAdmin, String passAdmin) throws SQLException {

        // String sql = "SELECT * FROM Admin WHERE ADMIN_LOGIN = ? and ADMIN_PASSWORD = ?";
        Transaction transaction = null;
        Session session = null;
        try {
           /* preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, loginAdmin);
            preparedStatement.setString(2, passAdmin);
            session = Connection.openSession();
            transaction = session.beginTransaction();
            NativeQuery spSQLQuery = session.createSQLQuery("SELECT * FROM Admin WHERE ADMIN_LOGIN = ? and ADMIN_PASSWORD = ?");
            spSQLQuery.setParameter(1, loginAdmin);
            spSQLQuery.setParameter(2, passAdmin);
            spSQLQuery.list();
            //resultSet = preparedStatement.executeQuery();
            if (!spSQLQuery.isCacheable()) {
                System.out.println("Not correct login and password.");
            } else {
                buttonAdmin.setOnMouseClicked(this::extracted);
            }

        } catch (Exception e) {
            e.getCause();
        } finally {
            transaction.commit();
        }
        session.close();
        //Admin admin=new Admin();
        // admin.setAdmin_login(loginAdmin);
        // admin.setAdmin_password(passAdmin);

        //  boolean logAdmin = service.equals(loginAdmin);
        //  boolean pasAd=service.equals(passAdmin);
       /* if(logAdmin==true && pasAd==true){
        }


    }*/
   /* public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }*/



