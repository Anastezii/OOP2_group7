package bg.tu_varna.sit.carrent.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Table(name = "user")
@Entity
@DiscriminatorValue("0")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="iduser",nullable = false,insertable = false,updatable = false)
    private Long id;


    @Column(name="user_login",nullable = false)
    private String login;

    @Column(name="user_password",nullable = false)
    private String password;


    @ManyToOne(optional = false)
    @JoinColumn(name = "iduser_type", nullable = false,insertable = false,updatable = false)
    private UserType iduserType;

    @ManyToOne
    @JoinColumn(name = "idADMIN",insertable = false,updatable = false)
    private Admin idADMIN;

    @ManyToOne
    @JoinColumn(name = "idOPERATOR",insertable = false,updatable = false)
    private Operator idOPERATOR;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idclient",insertable = false,updatable = false)
    private Client idclien;

    public Client getIdclient() {
        return idclien;
    }

    public void setIdclient(Client idclient) {
        this.idclien = idclien;
    }

    public Operator getIdOPERATOR() {
        return idOPERATOR;
    }

    public void setIdOPERATOR(Operator idOPERATOR) {
        this.idOPERATOR = idOPERATOR;
    }

    public Admin getIdADMIN() {
        return idADMIN;
    }

    public void setIdADMIN(Admin idADMIN) {
        this.idADMIN = idADMIN;
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

    public Client getIdclien() {
        return idclien;
    }

    public void setIdclien(Client idclien) {
        this.idclien = idclien;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login=" + login +
                ", password='" + password + '\'' +
                ", iduserType=" + iduserType +
                ", idADMIN=" + idADMIN +
                ", idOPERATOR=" + idOPERATOR +
                ", idclient=" + idclien +
                '}';
    }
}