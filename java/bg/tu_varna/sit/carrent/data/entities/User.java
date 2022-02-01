package bg.tu_varna.sit.carrent.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Table(name = "user")
@Entity

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iduser",nullable = false)
    private Long id;


    @Column(name="user_login",nullable = false)
    private String login;

    @Column(name="user_password",nullable = false)
    private String password;


    @ManyToOne(optional = false)
    @JoinColumn(name = "iduser_type", nullable = false)
    private UserType iduserType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idADMIN", nullable = true)
    private Admin admin;

    @OneToOne
    @JoinColumn(name = "idOPERATOR", nullable = true)
    private Operator operator;

    @OneToOne
    @JoinColumn(name = "idclient",nullable = true)
    private Client client;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() { }

    public User(String login, String password, UserType iduserType, Admin admin, Operator operator, Client client) {
        this.login = login;
        this.password = password;
        this.iduserType = iduserType;
        this.admin = admin;
        this.operator = operator;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public UserType getIduserType() {
        return iduserType;
    }

    public void setIduserType(UserType iduserType) {
        this.iduserType = iduserType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return " ";
    }
}