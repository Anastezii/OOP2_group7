package bg.tu_varna.sit.carrent.data.entities;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Table(name = "brand")
@Entity

public class Brand  implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idBRAND",nullable = false)
    private Long brand_id;

    @Column(name="BRAND_NAME",nullable = false)
    private String brand_name;

    public Brand() { }


    @OneToMany
            (fetch = FetchType.EAGER, mappedBy = "brand")
    private Set<Cars> cars;

    public Long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }



    public Set<Cars> getCars() {
        return cars;
    }

    public void setCars(Set<Cars> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brand_id=" + brand_id +

                '}';
    }
}
