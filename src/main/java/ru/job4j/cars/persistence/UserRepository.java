package ru.job4j.cars.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.User;

import java.util.Optional;

@Repository
public class UserRepository implements Wrapper {
    private final SessionFactory sf;

    public UserRepository(SessionFactory sf) {
        this.sf = sf;
    }

    public Optional<User> create(User user) {
        try {
            this.tx(session -> session.save(user), sf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }

    public User findById(int id) {
        return this.tx(session -> (User) session.createQuery("from User where id = :id")
                .setParameter("id", id).uniqueResult(), sf);
    }

    public Optional<User> findUserByNameEmailAndPwd(String name, String email, String password) {
        return this.tx(session -> session.createQuery(
                        "from User where name = :name and email = :email and password = :password"
                )
                .setParameter("name", name)
                .setParameter("email", email)
                .setParameter("password", password)
                .uniqueResultOptional(), sf);
    }
}