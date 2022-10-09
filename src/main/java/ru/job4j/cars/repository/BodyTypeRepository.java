package ru.job4j.cars.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.BodyType;

import java.util.List;

@Repository
public class BodyTypeRepository implements Wrapper {
    private final SessionFactory sf;

    public BodyTypeRepository(SessionFactory sf) {
        this.sf = sf;
    }

    public BodyType findById(int id) {
        return (BodyType) this.tx(session -> session.createQuery("from BodyType where id = :id")
                .setParameter("id", id).uniqueResult(), sf);
    }

    public List<BodyTypeRepository> findByAll() {
        return this.tx(session -> session.createQuery("from BodyType").list(), sf);
    }
}