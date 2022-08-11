package ru.job4j.cars.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Model;

import java.util.List;

@Repository
public class ModelRepository implements Wrapper {
    private final SessionFactory sf;

    public ModelRepository(SessionFactory sf) {
        this.sf = sf;
    }

    public Model findById(int id) {
        return (Model) this.tx(session -> session.createQuery("from Model where id = :id")
                .setParameter("id", id).uniqueResult(), sf);
    }

    public List findByAll() {
        return this.tx(session -> session.createQuery("from Model").list(), sf);
    }
}