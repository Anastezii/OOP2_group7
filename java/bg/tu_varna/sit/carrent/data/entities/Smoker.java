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
    private String smoker_type;

    @OneToMany
    (fetch = FetchType.LAZY, mappedBy = "idSMOKER")
    private Set<Cars> cars;

    public Long getSmoker_id() {
        return smoker_id;
    }

    public void setSmoker_id(Long smoker_id) {
        this.smoker_id = smoker_id;
    }



    public Set<Cars> getCars() {
        return cars;
    }

    public void setCars(Set<Cars> cars) {
        this.cars = cars;
    }

    public String getSmoker_Type() {
        return smoker_type;
    }

    public void setSmoker_id(String smoker_type) {
        this.smoker_type = smoker_type;
    }

    @Override
    public String toString() {
        return "Smoker{" +
                "smoker_id=" +smoker_id +
                ", smoker type='" + smoker_type + '\'' +
                ", cars=" + cars +
                '}';
    }
}
