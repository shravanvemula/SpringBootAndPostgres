package com.examle.postgres.repository;


import com.examle.postgres.entity.City;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Slf4j
public class CityRepositoryTest {

    @Autowired
    private CityRepository cityRepository;

    private City getCity1(){
        City city=new City();
        city.setName("shravan");
        city.setPopulation(120000);

        return city;

    }

    private City getCity2(){
        City city=new City();
        city.setName("Krishna");
        city.setPopulation(131000);

        return city;

    }

    @Test
    public void testRemoveCity(){
        City city = getCity1();
        City savedInDb = cityRepository.save(city);
        cityRepository.delete(city);
        boolean result=cityRepository.existsById(savedInDb.getId());

        assertThat(result).isEqualTo(false);
    }


    @Test
    public void testFindAll() {

        City city1=getCity1();
        City city2=getCity2();

        List<City> expectedCitiesList = new ArrayList<>();
        expectedCitiesList.add(city1);
        expectedCitiesList.add(city2);

        cityRepository.save(city1);
        cityRepository.save(city2);




        List<City> actualCities = (List<City>)cityRepository.findAll();

        assertThat(actualCities).isEqualTo(expectedCitiesList);
    }

    @Test
    public void testFindById() {
        City expectedCity=getCity1();
        cityRepository.save(expectedCity);
        Optional<City> actualUser=cityRepository.findById(expectedCity.getId());
        assertThat(actualUser.get()).isEqualTo(expectedCity);
    }









}
