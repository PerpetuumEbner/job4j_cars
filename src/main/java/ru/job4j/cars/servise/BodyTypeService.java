package ru.job4j.cars.servise;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.BodyType;
import ru.job4j.cars.repository.BodyTypeRepository;

import java.util.List;

@ThreadSafe
@Service
public class BodyTypeService {
    private final BodyTypeRepository bodyTypeRepository;

    public BodyTypeService(BodyTypeRepository bodyTypeRepository) {
        this.bodyTypeRepository = bodyTypeRepository;
    }

    public BodyType findById(int id) {
        return bodyTypeRepository.findById(id);
    }

    public List findByAll() {
        return bodyTypeRepository.findByAll();
    }
}