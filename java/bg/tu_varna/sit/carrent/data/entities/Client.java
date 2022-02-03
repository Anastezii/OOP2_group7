package bg.tu_varna.sit.carrent.data.entities;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Table(name = "client")
@Entity

public class Client implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    public Client() { }

    public Client(String cl_login, String cl_password) {
        this.cl_login = cl_login;
        this.cl_password = cl_password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idclient",nullable = false)
    private Long cl_id;


    @Column(name="client_login",nullable = false)
    private String cl_login;

    @Column(name="client_password",nullable = false)
    private String cl_password;

    @ManyToOne(optional = false)
    @JoinColumn(name = "oper_id_operator", nullable = false)
    private Operator oper;

    @OneToOne
    (fetch = FetchType.EAGER, mappedBy = "client")
    private User user;

    @OneToMany
    (fetch = FetchType.EAGER, mappedBy = "idcl")
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Client(Operator oper, Long cl_id, String cl_login, String cl_password) {
        this.oper = oper;
        this.cl_id = cl_id;
        this.cl_login = cl_login;
        this.cl_password = cl_password;
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
                ", user=" + user +
                ", rentSet=" + rentSet +
                '}';
    }
}
