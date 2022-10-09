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
@Table(name = "types")
public class BodyType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BodyType bodyType = (BodyType) o;
        return id == bodyType.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}