package com.examle.postgres.service;

import com.examle.postgres.entity.City;
import com.examle.postgres.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> findAll() {

        return (List<City>)cityRepository.findAll();
    }

    @Override
    public City findById(int id) {

        Optional<City> theCity = cityRepository.findById(id);

        if (theCity.get() == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        return theCity.get();
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);

    }

    @Override
    public void deleteById(int id) {
        cityRepository.deleteById(id);

    }
}
