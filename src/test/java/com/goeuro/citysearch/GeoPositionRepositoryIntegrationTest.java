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

import com.goeuro.citysearch.geoposition.GeoPosition;
import com.goeuro.citysearch.geoposition.GeoPositionDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CitysearchApplication.class)
@WebAppConfiguration
public class GeoPositionRepositoryIntegrationTest {

	@Autowired
	private GeoPositionDao geoPositionDao;

	@Test
	public void testFindGeoPositionWithExistingId() {
		GeoPosition geoPosition = geoPositionDao.findById(1l);
		assertEquals(false, Objects.isNull(geoPosition));
	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void testFindGeoPositionWithNonExistingId() {
		GeoPosition geoPosition = geoPositionDao.findById(50000l);
		assertEquals(true, Objects.isNull(geoPosition));
	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void testFindGeoPositionWithNull() {
		GeoPosition geoPosition = geoPositionDao.findById(null);
		assertEquals(true, Objects.isNull(geoPosition));
	}
}
