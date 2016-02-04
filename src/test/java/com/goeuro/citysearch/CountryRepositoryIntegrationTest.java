package com.goeuro.citysearch;

import static org.junit.Assert.assertEquals;

import java.util.Objects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.goeuro.citysearch.country.Country;
import com.goeuro.citysearch.country.CountryDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CitysearchApplication.class)
@WebAppConfiguration
public class CountryRepositoryIntegrationTest {

	@Autowired
	private CountryDao countryDao;

	@Test
	public void testFindCountryWithExistingId() {
		Country country = countryDao.findById(1l);
		assertEquals(false, Objects.isNull(country));
	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void testFindCountryWithNonExistingId() {
		Country country = countryDao.findById(50000l);
		assertEquals(true, Objects.isNull(country));
	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void testFindCountryWithNull() {
		Country country = countryDao.findById(null);
		assertEquals(true, Objects.isNull(country));
	}
}
