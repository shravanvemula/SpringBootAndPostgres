package com.examle.postgres.controller;

import com.examle.postgres.entity.City;
import com.examle.postgres.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityRestController {

    @Autowired
    private CityService cityService;


    @GetMapping("/cities")
    public List<City> findAll(){
        return cityService.findAll();
    }


    @GetMapping("/cities/{cityId}")
    public City getCity(@PathVariable int cityId) {

        City theCity = cityService.findById(cityId);

        if (theCity == null) {
            throw new RuntimeException("City id not found - " + cityId);
        }

        return theCity;
    }



    @PostMapping("/cities")
    public City addCity(@RequestBody City theCity) {
        
        theCity.setId(0);

        cityService.save(theCity);

        return theCity;
    }


    @PutMapping("/cities")
    public City updateCity(@RequestBody City theCity) {

        cityService.save(theCity);

        return theCity;
    }



    @DeleteMapping("/cities/{cityId}")
    public String deleteCity(@PathVariable int cityId) {

        City tempCity = cityService.findById(cityId);


        if (tempCity == null) {
            throw new RuntimeException("City id not found - " + cityId);
        }

        cityService.deleteById(cityId);

        return "Deleted city id - " + cityId;
    }




}
