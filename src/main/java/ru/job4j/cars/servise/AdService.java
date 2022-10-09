package ru.job4j.cars.servise;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Ad;
import ru.job4j.cars.repository.AdRepository;

import java.util.List;

@ThreadSafe
@Service
public class AdService {
    private final AdRepository adRepository;

    public AdService(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public void create(Ad ad) {
        adRepository.create(ad);
    }

    public Ad updateAd(Ad ad) {
        return adRepository.update(ad);
    }

    public void deleteAd(int id) {
        adRepository.delete(id);
    }

    public Ad findByIdAd(int id) {
        return adRepository.findById(id);
    }

    public List findByAll() {
        return adRepository.findByAll();
    }

    public void buy(int id) {
        adRepository.buy(id);
    }

    public void sell(int id) {
        adRepository.sell(id);
    }

    public List newAds() {
        return adRepository.newAds();
    }

    public List myAds(int id) {
        return adRepository.myAds(id);
    }
}