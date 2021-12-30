package bg.tu_varna.sit.carrent.data.entities;
import javafx.scene.input.DataFormat;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Table(name = "rent")
@Entity
@DiscriminatorValue("0")
public class Rent implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="idRENT",nullable = false,insertable = false,updatable = false)
    private Long rent_id;

    @Column(name="RENT_date",nullable = false)
    private LocalDate rent_date;


    @ManyToOne(optional = false)
    @JoinColumn(name = "idCARS", nullable = false,insertable = false,updatable = false)
    private Cars idCARS;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idoper", nullable = false,insertable = false,updatable = false)
    private Operator idoper;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idcl", nullable = false,insertable = false,updatable = false)
    private Client idcl;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idph", nullable = false,insertable = false,updatable = false)
    private Phirma idph;

    public Phirma getIdph() {
        return idph;
    }

    public void setIdph(Phirma idph) {
        this.idph = idph;
    }

    public Client getIdcl() {
        return idcl;
    }

    public void setIdcl(Client idcl) {
        this.idcl = idcl;
    }

    public Operator getIdoper() {
        return idoper;
    }

    public void setIdoper(Operator idoper) {
        this.idoper = idoper;
    }

    public Cars getIdCARS() {
        return idCARS;
    }

    public void setIdCARS(Cars idCARS) {
        this.idCARS = idCARS;
    }

    public Long getRent_id() {
        return rent_id;
    }

    public void setRent_id(Long rent_id) {
        this.rent_id = rent_id;
    }

    public LocalDate getRent_date() {
        return rent_date;
    }

    public void setRent_date(LocalDate rent_date) {
        this.rent_date = rent_date;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "rent_id=" + rent_id +
                ", rent_date=" + rent_date +
                ", idCARS=" + idCARS +
                ", idoper=" + idoper +
                ", idcl=" + idcl +
                ", idph=" + idph +
                '}';
    }
}
