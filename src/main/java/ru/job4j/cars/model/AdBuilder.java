package ru.job4j.cars.model;

import java.util.Date;

public interface AdBuilder {
    void setId(int id);

    void setName(String name);

    void setDescription(String description);

    void setPhoto(byte[] photo);

    void setCreated(Date created);

    void setStatus(boolean status);

    void setCar(Car car);

    void setUser(User user);
}