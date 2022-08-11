package ru.job4j.cars.servise;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.User;
import ru.job4j.cars.persistence.UserRepository;

import java.util.Optional;

@ThreadSafe
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> create(User user) {
        return userRepository.create(user);
    }

    public User findById(int id) {
        return userRepository.findById(id);
    }

    public Optional<User> findUserByNameEmailAndPwd(String name, String email, String password) {
        return userRepository.findUserByNameEmailAndPwd(name, email, password);
    }
}