package ru.job4j.cars.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Ad;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class AdRepository implements Wrapper {
    private final SessionFactory sf;

    public AdRepository(SessionFactory sf) {
        this.sf = sf;
    }

    public void create(Ad ad) {
        this.tx(session -> session.save(ad), sf);
    }

    public Ad update(Ad ad) {
        return this.tx(session -> {
            session.update(ad);
            return ad;
        }, sf);
    }

    public void delete(int id) {
        this.tx(session -> session.createQuery("delete from Ad where id = :id")
                .setParameter("id", id).executeUpdate(), sf);
    }

    public Ad findById(int id) {
        return (Ad) this.tx(session -> session.createQuery("from Ad where id = :id")
                .setParameter("id", id).uniqueResult(), sf);
    }

    public List<AdRepository> findByAll() {
        return this.tx(session -> session.createQuery("from Ad").list(), sf);
    }

    public void buy(int id) {
        this.tx(session -> session.createQuery("update Ad set status = true where id = :id")
                .setParameter("id", id).executeUpdate(), sf);
    }

    public void sell(int id) {
        this.tx(session -> session.createQuery("update Ad set status = false where id = :id")
                .setParameter("id", id).executeUpdate(), sf);
    }

    public List<AdRepository> newAds() {
        LocalDateTime dateTime = LocalDateTime.now().minusDays(1);
        Timestamp actualTime = Timestamp.valueOf(dateTime);
        return this.tx(session -> session.createQuery("select distinct a from Ad a where a.created > :actualTime")
                .setParameter("actualTime", actualTime).list(), sf);
    }

    public List<AdRepository> myAds(int id) {
        return this.tx(session -> session.createQuery("select distinct a from Ad a where a.user.id = :id")
                .setParameter("id", id).list(), sf);
    }

    public List<AdRepository> getAdPhoto() {
        return this.tx(session -> session.createQuery("select distinct a from Ad a where a.photo != null")
                .list(), sf);
    }

    public List<Ad> getAdBrand(String brandName) {
        return this.tx(session -> session.createQuery("select distinct a from Ad a "
                        + "join fetch a.car c "
                        + "join fetch c.model m "
                        + "join fetch m.name "
                        + "where m.name = :brandName", Ad.class)
                .setParameter("brandName", brandName).list(), sf);
    }
}