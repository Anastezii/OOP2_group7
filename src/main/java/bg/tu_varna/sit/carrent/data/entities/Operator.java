package bg.tu_varna.sit.carrent.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
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


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="idclient",nullable = false)
    private Set<Client> clientSet;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idadministr", nullable = false)
    private Admin idadministr;

    @OneToMany
    (fetch = FetchType.LAZY, mappedBy = "idoper")
    private Set<Rent> rents;

    public Set<Rent> getRents() {
        return rents;
    }

    public void setRents(Set<Rent> rents) {
        this.rents = rents;
    }

    @OneToMany
    (fetch = FetchType.LAZY, mappedBy = "idOPERATOR")
    private Set<User> users;

    public Admin getIdadministr() {
        return idadministr;
    }

    public void setIdadministr(Admin idadministr) {
        this.idadministr = idadministr;
    }

    public Set<Client> getClientSet() {
        return clientSet;
    }

    public void setClientSet(Set<Client> clientSet) {
        this.clientSet = clientSet;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "operator_id=" + operator_id +
                ", operator_login='" + operator_login + '\'' +
                ", operator_password='" + operator_password + '\'' +
                ", clientSet=" + clientSet +
                ", idadministr=" + idadministr +
                ", rents=" + rents +
                ", users=" + users +
                '}';
    }
}