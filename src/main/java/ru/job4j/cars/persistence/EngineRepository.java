package ru.job4j.cars.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Engine;

import java.util.List;

@Repository
public class EngineRepository implements Wrapper {
    private final SessionFactory sf;

    public EngineRepository(SessionFactory sf) {
        this.sf = sf;
    }

    public Engine findById(int id) {
        return (Engine) this.tx(session -> session.createQuery("from Engine where id = :id")
                .setParameter("id", id).uniqueResult(), sf);
    }

    public List findByAll() {
        return this.tx(session -> session.createQuery("from Engine").list(), sf);
    }
}