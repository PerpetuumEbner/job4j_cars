package ru.job4j.cars.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Brand;

import java.util.List;

@Repository
public class BrandRepository implements Wrapper {
    private final SessionFactory sf;

    public BrandRepository(SessionFactory sf) {
        this.sf = sf;
    }

    public Brand findById(int id) {
        return (Brand) this.tx(session -> session.createQuery("from Brand where id = :id")
                .setParameter("id", id).uniqueResult(), sf);
    }

    public List<BrandRepository> findByAll() {
        return this.tx(session -> session.createQuery("from Brand").list(), sf);
    }
}