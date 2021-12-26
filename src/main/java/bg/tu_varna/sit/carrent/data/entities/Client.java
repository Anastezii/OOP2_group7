package bg.tu_varna.sit.carrent.data.entities;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Table(name = "client")
@Entity
@DiscriminatorValue("0")
public class Client implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idclient",insertable = false, updatable = false)
    private Long cl_id;


    @Column(name="client_login",nullable = false)
    private User cl_login;

    @Column(name="client_password",nullable = false)
    private String cl_password;


    @ManyToOne(optional = false)
    @JoinColumn(name = "idoperators", nullable = false)
    private Operator idoperators;

    @OneToMany
    (fetch = FetchType.LAZY, mappedBy = "idclien")
    private Set<User>usersSet;

    @OneToMany
    (fetch = FetchType.LAZY, mappedBy = "idcl")
    private Set<Rent>rentSet;

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

    public Operator getIdoperators() {
        return idoperators;
    }

    public void setIdoperators(Operator idoperators) {
        this.idoperators = idoperators;
    }

    public Long getCl_id() {
        return cl_id;
    }

    public void setCl_id(Long cl_id) {
        this.cl_id = cl_id;
    }

    public User getCl_login() {
        return cl_login;
    }

    public void setCl_login(User cl_login) {
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
                ", idoperators=" + idoperators +
                ", usersSet=" + usersSet +
                ", rentSet=" + rentSet +
                '}';
    }
}
