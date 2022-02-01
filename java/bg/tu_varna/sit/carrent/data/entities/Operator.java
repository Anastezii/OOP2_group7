package bg.tu_varna.sit.carrent.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Table(name = "operator")
@Entity

public class Operator implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idOPERATOR",nullable = false)
    private Long operator_id;

    @Column(name="OPERATOR_LOGIN",nullable = false)
    private String operator_login;

    @Column(name="OPERATOR_PASSWORD",nullable = false)
    private String operator_password;

    public Operator() { }

    public Operator(String operator_login, String operator_password) {
        this.operator_login = operator_login;
        this.operator_password = operator_password;
    }

    public Operator(Long operator_id, String operator_login, String operator_password, Admin idadministr) {
        this.operator_id = operator_id;
        this.operator_login = operator_login;
        this.operator_password = operator_password;
        this.idadministr = idadministr;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "idadministr", nullable = false, insertable = false, updatable = false)
    private Admin idadministr;

    @OneToMany
    (fetch = FetchType.EAGER, mappedBy = "idoper")
    private Set<Rent> rents;

    public Set<Rent> getRents() {
        return rents;
    }

    public void setRents(Set<Rent> rents) {
        this.rents = rents;
    }

    @OneToOne
    (fetch = FetchType.EAGER, mappedBy = "operator")
    private User user;

    @OneToMany(mappedBy = "oper", orphanRemoval = true)
    private List<Client> clients = new ArrayList<>();

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Admin getIdadministr() {
        return idadministr;
    }

    public void setIdadministr(Admin idadministr) {
        this.idadministr = idadministr;
    }




    public Long getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(Long operator_id) {
        this.operator_id = operator_id;
    }

    public String getOperator_login() {
        return operator_login;
    }

    public void setOperator_login(String operator_login) {
        this.operator_login = operator_login;
    }

    public String getOperator_password() {
        return operator_password;
    }

    public void setOperator_password(String operator_password) {
        this.operator_password = operator_password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "operator_id=" + operator_id +
                ", operator_login='" + operator_login + '\'' +
                ", operator_password='" + operator_password + '\'' +
                ", clientSet=" + clients +
                ", idadministr=" + idadministr +
                ", rents=" + rents +
                ", user=" + user +
                '}';
    }
}