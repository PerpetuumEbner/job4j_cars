package ru.job4j.cars.controller;

import net.jcip.annotations.ThreadSafe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.job4j.cars.model.Ad;
import ru.job4j.cars.model.Car;
import ru.job4j.cars.model.User;
import ru.job4j.cars.servise.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;

@ThreadSafe
@Controller
public class AdController {
    private final AdService adService;
    private final BodyTypeService bodyTypeService;
    private final BrandService brandService;
    private final CarService carService;
    private final EngineService engineService;
    private final ModelService modelService;

    @Autowired
    public AdController(AdService adService,
                        BodyTypeService bodyTypeService,
                        BrandService brandService,
                        CarService carService,
                        EngineService engineService,
                        ModelService modelService) {
        this.adService = adService;
        this.bodyTypeService = bodyTypeService;
        this.brandService = brandService;
        this.carService = carService;
        this.engineService = engineService;
        this.modelService = modelService;
    }

    @GetMapping("/ads")
    public String findAds(Model model, HttpSession session) {
        userHttpSession(model, session);
        model.addAttribute("ads", adService.findByAll());
        return "ads";
    }

    @GetMapping("/formAddAd")
    public String addAd(Model model, HttpSession session) {
        userHttpSession(model, session);
        model.addAttribute("ad", new Ad());
        model.addAttribute("car", new Car());
        model.addAttribute("cars", carService.findByAll());
        model.addAttribute("models", modelService.findByAll());
        model.addAttribute("brands", brandService.findByAll());
        model.addAttribute("types", bodyTypeService.findByAll());
        model.addAttribute("engines", engineService.findByAll());
        return "addAd";
    }

    @PostMapping("/createAd")
    public String createAd(@ModelAttribute Ad ad, Car car,
                           @RequestParam("yearOfIssueId") int yearOfIssueId,
                           @RequestParam("modelId") int modelId,
                           @RequestParam("typeId") int typeId,
                           @RequestParam("engineId") int engineId,
                           @RequestParam("file") MultipartFile file) throws IOException {
        ad.setCreated(Date.from(Instant.now()));
        car.setYearOfIssue(carService.findById(yearOfIssueId).getYearOfIssue());
        car.setModel(modelService.findById(modelId));
        car.setType(bodyTypeService.findById(typeId));
        car.setEngine(engineService.findById(engineId));
        carService.create(car);
        ad.setCar(car);
        ad.setPhoto(file.getBytes());
        adService.create(ad);
        return "redirect:/ads";
    }

    @GetMapping("/ads/{adId}")
    public String findAd(Model model, @PathVariable("adId") int id, HttpSession session) {
        User user = userHttpSession(model, session);
        model.addAttribute("user", user);
        model.addAttribute("ad", adService.findByIdAd(id));
        model.addAttribute("condition", adService.findByIdAd(id).getUser().getId() == user.getId());
        return "/ad";
    }

    @GetMapping("/delete/{adId}")
    public String delete(Model model, @PathVariable("adId") int id, HttpSession session) {
        userHttpSession(model, session);
        adService.deleteAd(id);
        return "redirect:/ads";
    }

    @GetMapping("/formUpdateAd/{adId}")
    public String updateAd(Model model, @PathVariable("adId") int id, HttpSession session) {
        userHttpSession(model, session);
        model.addAttribute("ad", adService.findByIdAd(id));
        model.addAttribute("car", carService.findById(id));
        model.addAttribute("model", modelService.findById(id));
        model.addAttribute("brand", brandService.findById(id));
        model.addAttribute("type", bodyTypeService.findById(id));
        model.addAttribute("engine", engineService.findById(id));
        return "/updateAd";
    }

    @PostMapping("/updateAd")
    public String updateAd(@ModelAttribute Ad ad, @RequestParam("file") MultipartFile file) throws IOException {
        ad.setCreated(Date.from(Instant.now()));
        ad.setPhoto(file.getBytes());
        adService.updateAd(ad);
        return "redirect:/ads";
    }

    @GetMapping("/newAds")
    public String actualAds(Model model, HttpSession session) {
        userHttpSession(model, session);
        model.addAttribute("ads", adService.newAds());
        return "/ads";
    }

    @GetMapping("/myAds")
    public String myAds(Model model, HttpSession session) {
        User user = userHttpSession(model, session);
        model.addAttribute("ads", adService.myAds(user.getId()));
        return "/ads";
    }

    @GetMapping("/buy/{adId}")
    public String buy(@PathVariable("adId") int id) {
        adService.buy(id);
        return "redirect:/ads";
    }

    @GetMapping("/sell/{adId}")
    public String sell(@PathVariable("adId") int id) {
        adService.sell(id);
        return "redirect:/ads";
    }

    @GetMapping("/photoAdd/{adId}")
    public ResponseEntity<Resource> download(@PathVariable("adId") int id) {
        Ad ad = adService.findByIdAd(id);
        return ResponseEntity.ok()
                .headers(new HttpHeaders())
                .contentLength(ad.getPhoto().length)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new ByteArrayResource(ad.getPhoto()));
    }

    private User userHttpSession(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            user.setName("Гость");
        }
        model.addAttribute("user", user);
        return user;
    }
}