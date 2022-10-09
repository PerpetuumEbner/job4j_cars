package ru.job4j.cars.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int yearOfIssue;

    @ManyToOne
    @JoinColumn(name = "model_id", foreignKey = @ForeignKey(name = "MODEL_ID_FK"))
    private Model model;

    @ManyToOne
    @JoinColumn(name = "type_id", foreignKey = @ForeignKey(name = "TYPE_ID_FK"))
    private BodyType type;

    @ManyToOne
    @JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private Engine engine;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return id == car.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}