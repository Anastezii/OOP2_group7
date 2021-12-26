package bg.tu_varna.sit.carrent.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Table(name = "admin")
@Entity

public class Admin implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="idADMIN",nullable = false)
    private Long admin_id;

    @Column(name="ADMIN_LOGIN",nullable = false)
    private String admin_login;

    @Column(name="ADMIN_PASSWORD",nullable = false)
    private String admin_password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idadministr")
    private Set<Operator> operatorSet;

    @OneToMany
    (fetch = FetchType.LAZY, mappedBy =  "idADMIN")
    private Set<User> userSet;

    @OneToMany
            (fetch = FetchType.LAZY, mappedBy =  "idad")
    private Set<Phirma> phirmaSet;

    public Set<Phirma> getPhirmaSet() {
        return phirmaSet;
    }

    public void setPhirmaSet(Set<Phirma> phirmaSet) {
        this.phirmaSet = phirmaSet;
    }

    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_login() {
        return admin_login;
    }

    public void setAdmin_login(String admin_login) {
        this.admin_login = admin_login;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public Set<Operator> getOperatorSet() {
        return operatorSet;
    }

    public void setOperatorSet(Set<Operator> operatorSet) {
        this.operatorSet = operatorSet;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", admin_login='" + admin_login + '\'' +
                ", admin_password='" + admin_password + '\'' +
                ", operatorSet=" + operatorSet +
                ", userSet=" + userSet +
                ", phirmaSet=" + phirmaSet +
                '}';
    }
}