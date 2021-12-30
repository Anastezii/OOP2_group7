package bg.tu_varna.sit.carrent.data.entities;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;
@Table(name = "cars")
@Entity
@DiscriminatorValue("0")
public class Cars implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="idCARS",nullable = false)
    private Long cars_id;

    @Column(name="CARS_CLASS",nullable = false)
    private String cars_class;

    @Column(name="CARS_COLOR",nullable = false)
    private String cars_color;

    @Column(name="CARS_REG_NUM",nullable = false)
    private String cars_reg_num;

    @Column(name="CARSYEAR",nullable = false)
    private String cars_year;

    @OneToMany
    (fetch = FetchType.LAZY, mappedBy = "idCARS")
    private Set<Rent> rents;

    public Set<Rent> getRents() {
        return rents;
    }

    public void setRents(Set<Rent> rents) {
        this.rents = rents;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "idMODEL", nullable = false,insertable = false,updatable = false)
    private Model idMODEL;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idSMOKER", nullable = false,insertable = false,updatable = false)
    private Smoker idSMOKER;

    public Smoker getIdSMOKER() {
        return idSMOKER;
    }

    public void setIdSMOKER(Smoker idSMOKER) {
        this.idSMOKER = idSMOKER;
    }

    public Model getIdMODEL() {
        return idMODEL;
    }

    public void setIdMODEL(Model idMODEL) {
        this.idMODEL = idMODEL;
    }

    public Long getCars_id() {
        return cars_id;
    }

    public void setCars_id(Long cars_id) {
        this.cars_id = cars_id;
    }

    public String getCars_class() {
        return cars_class;
    }

    public void setCars_class(String cars_class) {
        this.cars_class = cars_class;
    }

    public String getCars_color() {
        return cars_color;
    }

    public void setCars_color(String cars_color) {
        this.cars_color = cars_color;
    }

    public String getCars_reg_num() {
        return cars_reg_num;
    }

    public void setCars_reg_num(String cars_reg_num) {
        this.cars_reg_num = cars_reg_num;
    }

    public String getCars_year() {
        return cars_year;
    }

    public void setCars_year(String cars_year) {
        this.cars_year = cars_year;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars_id=" + cars_id +
                ", cars_class='" + cars_class + '\'' +
                ", cars_color=" + cars_color +
                ", cars_reg_num='" + cars_reg_num + '\'' +
                ", cars_year='" + cars_year + '\'' +
                ", rents=" + rents +
                ", idMODEL=" + idMODEL +
                ", idSMOKER=" + idSMOKER +
                '}';
    }
}
