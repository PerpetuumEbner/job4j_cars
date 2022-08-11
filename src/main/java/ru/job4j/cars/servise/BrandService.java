package ru.job4j.cars.servise;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Brand;
import ru.job4j.cars.persistence.BrandRepository;

import java.util.List;

@ThreadSafe
@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand findById(int id) {
        return brandRepository.findById(id);
    }

    public List findByAll() {
        return brandRepository.findByAll();
    }
}
