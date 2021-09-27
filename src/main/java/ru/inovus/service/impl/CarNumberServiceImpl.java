package ru.inovus.service.impl;

import org.springframework.stereotype.Service;
import ru.inovus.service.CarNumberService;
import ru.inovus.util.CarNumberUtil;

@Service
public class CarNumberServiceImpl implements CarNumberService {

    @Override
    public String getRandomNumber() {
        return CarNumberUtil.getRandomNumber();
    }

    @Override
    public String getNextNumber() {
        return CarNumberUtil.getNextNumber();
    }
}
