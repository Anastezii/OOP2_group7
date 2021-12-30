package bg.tu_varna.sit.carrent.data.entities;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Table(name = "client")
@Entity
@DiscriminatorValue("0")
public class Client implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    @ManyToOne(optional = false)
    @JoinColumn(name = "oper_id_operator", nullable = false,insertable = false,updatable = false)
    private Operator oper;

    public Client() { }

    public Client(String cl_login, String cl_password) {
        this.cl_login = cl_login;
        this.cl_password = cl_password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idclient",nullable = false,insertable = false, updatable = false)
    private Long cl_id;


    @Column(name="client_login",nullable = false)
    private String cl_login;

    @Column(name="client_password",nullable = false)
    private String cl_password;



    @OneToMany
    (fetch = FetchType.LAZY, mappedBy = "idclien")
    private Set<User>usersSet;

    @OneToMany
    (fetch = FetchType.LAZY, mappedBy = "idcl")
    private Set<Rent>rentSet;

    public Operator getOper() {
        return oper;
    }

    public void setOper(Operator oper) {
        this.oper = oper;
    }



    public Set<Rent> getRentSet() {
        return rentSet;
    }

    public void setRentSet(Set<Rent> rentSet) {
        this.rentSet = rentSet;
    }

    public Set<User> getUsersSet() {
        return usersSet;
    }

    public void setUsersSet(Set<User> usersSet) {
        this.usersSet = usersSet;
    }





    public Long getCl_id() {
        return cl_id;
    }

    public void setCl_id(Long cl_id) {
        this.cl_id = cl_id;
    }

    public String getCl_login() {
        return cl_login;
    }

    public void setCl_login(String cl_login) {
        this.cl_login = cl_login;
    }

    public String getCl_password() {
        return cl_password;
    }

    public void setCl_password(String cl_password) {
        this.cl_password = cl_password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "cl_id=" + cl_id +
                ", cl_login=" + cl_login +
                ", cl_password='" + cl_password + '\'' +

                ", usersSet=" + usersSet +
                ", rentSet=" + rentSet +
                '}';
    }
}
