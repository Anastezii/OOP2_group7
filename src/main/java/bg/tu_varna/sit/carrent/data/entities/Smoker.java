package bg.tu_varna.sit.carrent.data.entities;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Table(name = "smoker")
@Entity
public class Smoker implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="idSMOKER",nullable = false)
    private Long admin_id;

    @Column(name="SMOKER_TYPE",nullable = false)
    private String admin_login;

    @OneToMany
    (fetch = FetchType.LAZY, mappedBy = "idSMOKER")
    private Set<Cars> cars;

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

    public Set<Cars> getCars() {
        return cars;
    }

    public void setCars(Set<Cars> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Smoker{" +
                "admin_id=" + admin_id +
                ", admin_login='" + admin_login + '\'' +
                ", cars=" + cars +
                '}';
    }
}
