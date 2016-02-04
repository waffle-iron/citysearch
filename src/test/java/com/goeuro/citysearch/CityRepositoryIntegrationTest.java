package com.goeuro.citysearch;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.goeuro.citysearch.city.City;
import com.goeuro.citysearch.city.CityDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CitysearchApplication.class)
@WebAppConfiguration
public class CityRepositoryIntegrationTest {

	@Autowired
	private CityDao cityDao;

	@Test
	public void testFindCityWithExistingCityName() {
		String cityName = "Potsdam";
		List<City> cities = cityDao.findByName(cityName);
		assertEquals(1, cities.size());
	}

	@Test
	public void testFindCityWithNonExistingCityName() {
		String cityName = "non-existing-city-name";
		List<City> cities = cityDao.findByName(cityName);
		assertEquals(0, cities.size());
	}

	@Test
	public void testFindCityWithNull() {
		List<City> cities = cityDao.findByName(null);
		assertEquals(0, cities.size());
	}

}
