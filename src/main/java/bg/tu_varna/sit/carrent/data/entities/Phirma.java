package bg.tu_varna.sit.carrent.data.entities;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Table(name = "phirma")
@Entity
@DiscriminatorValue("0")
public class Phirma implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    public Phirma() { }

    public Phirma(String ph_name) {
        this.ph_name = ph_name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="idPhirma",nullable = false,columnDefinition = "int default 1")
    private Long ph_id;

    @Column(name="Phirma_name",nullable = false)
    private String ph_name;


    @ManyToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "idad", nullable = false,insertable = true,updatable = true)
    private Admin idad;

    @OneToMany
    ( fetch = FetchType.LAZY, mappedBy = "idph")
    private Set<Rent> rentssEt;

    public Phirma(Admin idad) {
        this.idad = idad;
    }

    public Set<Rent> getRentssEt() {
        return rentssEt;
    }

    public void setRentssEt(Set<Rent> rentssEt) {
        this.rentssEt = rentssEt;
    }

    public Admin getIdad() {
        return idad;
    }

    public void setIdad(Admin idad) {
        this.idad = idad;
    }

    public Long getPh_id() {
        return ph_id;
    }

    public void setPh_id(Long ph_id) {
        this.ph_id = ph_id;
    }

    public String getPh_name() {
        return ph_name;
    }

    public void setPh_name(String ph_name) {
        this.ph_name = ph_name;
    }

    @Override
    public String toString() {
        return "Phirma{" +
                "ph_id=" + ph_id +
                ", ph_name='" + ph_name + '\'' +
                ", idad=" + idad +
                ", rentssEt=" + rentssEt +
                '}';
    }
}
