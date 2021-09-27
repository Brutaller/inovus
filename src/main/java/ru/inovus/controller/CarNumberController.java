package ru.inovus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.inovus.service.CarNumberService;

@RestController
@RequestMapping("/number")
public class CarNumberController {
    @Autowired
    CarNumberService carNumberService;

    @GetMapping("/next")
    public String getNextNumber(){
        return carNumberService.getNextNumber();
    }

    @GetMapping("/random")
    public String getRandomNumber(){
        return carNumberService.getRandomNumber();
    }
}
