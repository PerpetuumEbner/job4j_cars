package ru.job4j.cars.servise;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Model;
import ru.job4j.cars.repository.ModelRepository;

import java.util.List;

@ThreadSafe
@Service
public class ModelService {
    private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public Model findById(int id) {
        return modelRepository.findById(id);
    }

    public List findByAll() {
        return modelRepository.findByAll();
    }
}
