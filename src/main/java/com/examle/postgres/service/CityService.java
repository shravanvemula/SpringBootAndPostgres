package com.examle.postgres.service;

import com.examle.postgres.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CityService {

    List<City> findAll();

    City findById(int id);

    void save(City city);

    void deleteById(int id);

}
