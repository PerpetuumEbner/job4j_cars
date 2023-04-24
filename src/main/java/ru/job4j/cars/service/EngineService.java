package ru.job4j.cars.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Engine;
import ru.job4j.cars.repository.EngineRepository;

import java.util.List;

@ThreadSafe
@Service
public class EngineService {
    public final EngineRepository engineRepository;

    public EngineService(EngineRepository engineRepository) {
        this.engineRepository = engineRepository;
    }

    public Engine findById(int id) {
        return engineRepository.findById(id);
    }

    public List findByAll() {
        return engineRepository.findByAll();
    }
}
