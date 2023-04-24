package ru.job4j.cars.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.User;

import java.util.Optional;

@Repository
public class UserRepository implements Wrapper {
    private static final Logger LOG = LogManager.getLogger(UserRepository.class);

    private final SessionFactory sf;

    public UserRepository(SessionFactory sf) {
        this.sf = sf;
    }

    public Optional<User> create(User user) {
        try {
            this.tx(session -> session.save(user), sf);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return Optional.ofNullable(user);
    }

    public User findById(int id) {
        return this.tx(session -> (User) session.createQuery("from User where id = :id")
                .setParameter("id", id).uniqueResult(), sf);
    }

    public Optional<User> findUserByNameEmailAndPassword(String name, String email, String password) {
        return this.tx(session -> session.createQuery(
                        "from User where name = :name and email = :email and password = :password"
                )
                .setParameter("name", name)
                .setParameter("email", email)
                .setParameter("password", password)
                .uniqueResultOptional(), sf);
    }
}