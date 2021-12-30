package bg.tu_varna.sit.carrent.data.entities;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Table(name = "smoker")
@Entity
@DiscriminatorValue("0")
public class Smoker implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="idSMOKER",nullable = false,insertable = false,updatable = false)
    private Long smoker_id;

    @Column(name="SMOKER_TYPE",nullable = false)
    private String admin_login;

    @OneToMany
    (fetch = FetchType.LAZY, mappedBy = "idSMOKER")
    private Set<Cars> cars;

    public Long getSmoker_id() {
        return smoker_id;
    }

    public void setSmoker_id(Long smoker_id) {
        this.smoker_id = smoker_id;
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
                "smoker_id=" +smoker_id +
                ", admin_login='" + admin_login + '\'' +
                ", cars=" + cars +
                '}';
    }
}
