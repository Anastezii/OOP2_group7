package bg.tu_varna.sit.carrent.data.entities;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Table(name = "userType")
@Entity
@DiscriminatorValue("0")
public class UserType implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUSER_TYPE",nullable = false,insertable = false,updatable = false)
    private Long userType_id;


    @Column(name="USER_TYPE_NAME",nullable = false)
    private String user_type_name;

    @OneToMany
    @JoinColumn(name = "iduser_type",nullable = false,insertable = false,updatable = false)
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Long getUserType_id() {
        return userType_id;
    }

    public void setUserType_id(Long userType_id) {
        this.userType_id = userType_id;
    }

    public String getUser_type_name() {
        return user_type_name;
    }

    public void setUser_type_name(String user_type_name) {
        this.user_type_name = user_type_name;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "userType_id=" + userType_id +
                ", user_type_name=" + user_type_name +
                ", users=" + users +
                '}';
    }
}
