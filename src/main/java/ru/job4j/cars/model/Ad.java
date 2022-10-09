package ru.job4j.cars.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private byte[] photo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    private int mileage;

    private boolean status;

    private int price;

    @ManyToOne
    @JoinColumn(name = "car_id", foreignKey = @ForeignKey(name = "CAR_ID_FK"))
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "USER_ID_FK"))
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ad ad = (Ad) o;
        return id == ad.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}