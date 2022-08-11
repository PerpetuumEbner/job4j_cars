package ru.job4j.cars.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Car;

import java.util.List;

@Repository
public class CarRepository implements Wrapper {
    private final SessionFactory sf;

    public CarRepository(SessionFactory sf) {
        this.sf = sf;
    }

    public void create(Car car) {
        this.tx(session -> session.save(car), sf);
    }

    public Car update(Car car) {
        return this.tx(session -> {
            session.update(car);
            return car;
        }, sf);
    }

    public void delete(int id) {
        this.tx(session -> session.createQuery("delete from Car where id = :id")
                .setParameter("id", id).executeUpdate(), sf);
    }

    public Car findById(int id) {
        return (Car) this.tx(session -> session.createQuery("from Car where id = :id")
                .setParameter("id", id).uniqueResult(), sf);
    }

    public List findByAll() {
        return this.tx(session -> session.createQuery("from Car").list(), sf);
    }
}