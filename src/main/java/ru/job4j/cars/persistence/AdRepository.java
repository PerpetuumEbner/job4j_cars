package ru.job4j.cars.persistence;

import org.hibernate.SessionFactory;
import ru.job4j.cars.model.Ad;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class AdRepository implements Wrapper {
    private final SessionFactory sf;

    public AdRepository(SessionFactory sf) {
        this.sf = sf;
    }

    public List actualAd() {
        LocalDateTime dateTime = LocalDateTime.now().minusDays(1);
        Timestamp actualTime = Timestamp.valueOf(dateTime);
        return this.tx(session -> session.createQuery("select distinct a from Ad a where a.created < created - :actualTime")
                .setParameter("actualTime", actualTime).list(), sf);
    }

    public List getAdPhoto() {
        return this.tx(session -> session.createQuery("select distinct a from Ad a where a.photo != null")
                .list(), sf);
    }

    public List getAdBrand(String brandName) {
        return this.tx(session -> session.createQuery("select distinct a from Ad a "
                        + "join fetch a.car c "
                        + "join fetch c.brand b "
                        + "join fetch b.name "
                        + "where b.name = :brandName", Ad.class)
                .setParameter("brandName", brandName).list(), sf);
    }
}